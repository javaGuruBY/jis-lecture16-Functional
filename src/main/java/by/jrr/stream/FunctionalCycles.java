package by.jrr.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FunctionalCycles {

    static Logger logger = LoggerFactory.getLogger(FunctionalCycles.class);

    public static void main(String[] args) {
        List<String> names = List.of("maxim", "tatjana", "olga", "Tolja");

        names.forEach(FunctionalCycles::logInfo);
    }

    public static void logInfo(String message) {
        logger.info(message);
    }
}
