package by.jrr.functional.service;

public interface MailJob {
    void send();
    default void sendByDefault() {
        System.out.println("default method called");
    }
}
