package by.jrr.functional;


import by.jrr.functional.service.MailJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        executeJob(() -> ((MailJob) () -> {}).sendByDefault());
    }

    private static void executeJob(Runnable threadLogic) {
        new Thread(threadLogic).start();
    }
}

