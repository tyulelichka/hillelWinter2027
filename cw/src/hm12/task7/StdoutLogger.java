package hm12.task7;

import hm12.LoggingLevel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StdoutLogger implements Logger {
    private final StdoutLoggerConfiguration config;
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public StdoutLogger(StdoutLoggerConfiguration config) {
        this.config = config;
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
        String currentTime = LocalDateTime.now().format(dateFormatter);
        String logMessage = String.format(config.getFormat(), currentTime, level, message);
        System.out.println(logMessage);
    }
}