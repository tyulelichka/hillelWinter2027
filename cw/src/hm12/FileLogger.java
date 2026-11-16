package hm12;

import hm12.task7.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {
    private FileLoggerConfiguration config;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter fileTimestampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public FileLoggerConfiguration getConfig() {
        return config;
    }

    public static DateTimeFormatter getFileTimestampFormatter() {
        return fileTimestampFormatter;
    }

    @Override
    public void info(String message) {
        log(LoggingLevel.INFO, message);
    }

    @Override
    public void debug(String message) {
        if (config.getCurrentLevel() == LoggingLevel.DEBUG) {
            log(LoggingLevel.DEBUG, message);
        }
    }

    private void log(LoggingLevel level, String message) {
        String formattedMessage = String.format(config.getFormat(),
                LocalDateTime.now().format(formatter),
                level,
                message) + System.lineSeparator();

        byte[] bytesToWrite = formattedMessage.getBytes();

        File file = new File(config.getFilePath());

        if (file.exists() && file.length() + bytesToWrite.length > config.getMaxSize()) {
            createNewLogFile();
            file = new File(config.getFilePath());
        }

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(formattedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewLogFile() {
        String timestamp = LocalDateTime.now().format(fileTimestampFormatter);

        String originalPath = config.getFilePath();
        String newFilePath;

        int dotIndex = originalPath.lastIndexOf('.');
        if (dotIndex != -1) {
            String name = originalPath.substring(0, dotIndex);
            String extension = originalPath.substring(dotIndex);
            newFilePath = name + "_" + timestamp + extension;
        } else {
            newFilePath = originalPath + "_" + timestamp + ".txt";
        }

        this.config = new FileLoggerConfiguration(
                newFilePath,
                config.getCurrentLevel(),
                config.getMaxSize(),
                config.getFormat()
        );
    }

    private void checkAndInitializeFile() {
        File file = new File(config.getFilePath());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


