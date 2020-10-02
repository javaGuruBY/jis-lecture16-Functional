package by.jrr.functional.threading;

import static by.jrr.functional.App.logger;

public class MyRunnable implements Runnable {

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        logger.info("this is a thread {}", name);
    }
}
