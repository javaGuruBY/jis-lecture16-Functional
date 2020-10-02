package by.jrr.functional.service;


import static by.jrr.functional.App.logger;
import static by.jrr.functional.App.logger;

public class SendRegistationConfirmMail extends Thread implements MailJob {
    @Override
    public void send() {
        logger.info("user registered, email sent");
    }

    @Override
    public void run() {
        send();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("user registered, email sent");
    }
}
