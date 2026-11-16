package hm12;

public class Main {
    public static void main(String[] args) {

        FileLoggerConfiguration config = new FileLoggerConfiguration(
                "log.txt",
                LoggingLevel.DEBUG,
                1024,
                "%s [%s] : %s"
        );

        FileLogger logger = new FileLogger(config);

        logger.info("It's info message.");
        logger.debug("It's debug message.");


        FileLoggerConfiguration config1 = new FileLoggerConfiguration(
                "program.log",
                LoggingLevel.DEBUG,
                500, // ліміт 500 байтів    
                "[%s][%s] Message: [%s]"
        );

        FileLogger logger1 = new FileLogger(config1);

        try {
            logger1.info("Program starts.");
            logger1.debug("Variable X is initialized with the value 10.");
            logger1.info("The program finished successfully.");
        } catch (FileMaxSizeReachedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
