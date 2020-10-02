package by.jrr.functional.threading;

import static by.jrr.functional.App.logger;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        logger.info("this is a thread {}", getName());
    }
}
