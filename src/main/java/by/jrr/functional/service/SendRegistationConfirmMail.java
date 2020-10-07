package by.jrr.functional.service;


import static by.jrr.functional.App.logger;
import static by.jrr.functional.App.logger;

public class SendRegistationConfirmMail implements MailJob {
    @Override
    public void send() {
        logger.info("user registered, email sent");
    }
}
