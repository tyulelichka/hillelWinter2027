package hm12;

public class FileMaxSizeReachedException extends RuntimeException {
    public FileMaxSizeReachedException(String filePath, long currentSize, long maxSize) {
        super(String.format("File max size reached! Path: '%s', Current size: %d bytes, Max allowed size: %d bytes.",
                filePath, currentSize, maxSize));
    }
}