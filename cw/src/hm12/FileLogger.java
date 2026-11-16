package hm12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private FileLoggerConfiguration config;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public FileLoggerConfiguration getConfig() {
        return config;
    }


    public void info(String message){
        log(LoggingLevel.INFO, message);
    }

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

        if (file.exists()) {
            if (file.length() + bytesToWrite.length > config.getMaxSize()) {
                throw new FileMaxSizeReachedException(config.getFilePath(), file.length(), config.getMaxSize());
            }
        }


        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(formattedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


