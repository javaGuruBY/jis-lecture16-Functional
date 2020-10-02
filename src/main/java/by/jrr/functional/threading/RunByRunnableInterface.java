package by.jrr.functional.threading;

public class RunByRunnableInterface {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable("my name"));
        Thread thread1 = new Thread(new MyRunnable(""), "thread name");
        Thread thread2 = new Thread(new MyRunnable("1"));
        Thread thread3 = new Thread(new MyRunnable("2"));
        Thread thread4 = new Thread(new MyRunnable("3"));
        Thread thread5 = new Thread(new MyRunnable("4"));
        Thread thread6 = new Thread(new MyRunnable("5"));
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

    }
}
