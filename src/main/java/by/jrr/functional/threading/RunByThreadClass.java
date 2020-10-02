package by.jrr.functional.threading;

public class RunByThreadClass {
    public static void main(String[] args) {
        MyThread thread = new MyThread("0");
        MyThread thread1 = new MyThread("1");
        MyThread thread2 = new MyThread("2");
        MyThread thread3 = new MyThread("3");
        MyThread thread4 = new MyThread("4");
        MyThread thread5 = new MyThread("5");
        MyThread thread6 = new MyThread("6");
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
