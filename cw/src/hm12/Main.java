package hm12;

import hm12.task7.Logger;
import hm12.task7.StdoutLogger;
import hm12.task7.StdoutLoggerConfiguration;

public class Main {
    public static void main(String[] args) {
        FileLoggerConfiguration fileConfig = new FileLoggerConfiguration("app.log", LoggingLevel.DEBUG, 1024, "[%s][%s] Message: [%s]");
        Logger logger = new FileLogger(fileConfig);

        StdoutLoggerConfiguration stdoutConfig = new StdoutLoggerConfiguration(LoggingLevel.DEBUG, "[%s][%s] Message: [%s]");
        Logger logger1 = new StdoutLogger(stdoutConfig);

        logger.info("Program starts.");
        logger.debug("It's debug message.");

        logger1.info("Program starts.");
        logger1.debug("It's debug message.");
    }
}

