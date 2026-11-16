package hm12.task7;

import hm12.LoggingLevel;

public class StdoutLoggerConfiguration {
    private LoggingLevel currentLevel;
    private String format;

    public StdoutLoggerConfiguration(LoggingLevel currentLevel, String format) {
        this.currentLevel = currentLevel;
        this.format = format;
    }

    public LoggingLevel getCurrentLevel() {
        return currentLevel;
    }

    public String getFormat() {
        return format;
    }
}