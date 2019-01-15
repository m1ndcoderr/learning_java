package ru.evgenyhodz.jmm;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 19.03.2017
 */
public class Demo implements Runnable {
    private int balance;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            increment();
            System.out.println(Thread.currentThread().getName() + " " + balance);
        }
    }

    private void increment() {
        int i = balance;
        balance = i + 1;
    }

    public static void main(String[] args) {
        Demo job = new Demo();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.start();
        b.start();
    }
}
