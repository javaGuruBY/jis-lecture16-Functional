package by.jrr.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamSytax {
    static Logger logger = LoggerFactory.getLogger(FunctionalCycles.class);
    public static void logInfo(String message) {
        logger.info(message);
    }
    public static void logInfo(Integer message) {
        logger.info(String.valueOf(message));
    }
    public static void logInfo(Object message) {
        logger.info(message.toString());
    }
}
