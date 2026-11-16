package hm12;

public class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel currentLevel;
    private long maxSize;
    private String format;

    public FileLoggerConfiguration(String filePath, LoggingLevel currentLevel, long maxSize, String format){
        this.filePath = filePath;
        this.currentLevel = currentLevel;
        this.format = format;
        this.maxSize = maxSize;
    }

    public LoggingLevel getCurrentLevel() {
        return currentLevel;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFormat() {
        return format;
    }

    public void setCurrentLevel(LoggingLevel currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }
}
