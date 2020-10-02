package by.jrr.functional.threading;

import static by.jrr.functional.App.logger;

public class MyThread3 extends Thread {

    long pause;

    public MyThread3(long pause) {
        this.pause = pause;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("this is another thread {}", getName());
    }
}
