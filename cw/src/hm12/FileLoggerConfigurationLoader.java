package hm12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {

    public FileLoggerConfiguration load(String configFilepath) {
        String filePath = null;
        LoggingLevel level = null;
        long maxSize = 0;
        String format = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(configFilepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length < 2) continue;

                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "FILE":
                        filePath = value;
                        break;
                    case "LEVEL":
                        level = LoggingLevel.valueOf(value.toUpperCase());
                        break;
                    case "MAX-SIZE":
                        maxSize = Long.parseLong(value);
                        break;
                    case "FORMAT":
                        format = value;
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading configuration file: " + e.getMessage(), e);
        }

        return new FileLoggerConfiguration(filePath, level, maxSize, format);
    }
}