package ru.evgenyhodz.ms;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.03.2017
 */
public class Count {
    /**
     * Field for not synchronized method.
     */
    private int result = 0;
    /**
     * Field for synchronized method.
     */
    private int sResult = 0;

    /**
     * Increases result field by 1.
     */
    private void increment() {
        this.result++;
    }

    /**
     * Increases sResult field by 1.
     */
    private synchronized void sIncrement() {
        this.sResult++;
    }

    /**
     * Getter.
     *
     * @return result of not-synchronized method.
     */
    public synchronized int getResult() {
        return result;
    }

    /**
     * Getter.
     *
     * @return result of synchronized method.
     */
    public synchronized int getsResult() {
        return sResult;
    }

    /**
     * Class to do not synchronized method 1 million times.
     */
    private class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                increment();
            }
        }
    }

    /**
     * Class to do synchronized method 1 million times.
     */
    private class MySync extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                sIncrement();
            }
        }
    }

    /**
     * Creates 2 threads to increase value and prints result.
     */
    public void notSyncAction() {
        MyThread first = new MyThread();
        MyThread second = new MyThread();
        first.start();
        second.start();
        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(result);
    }

    /**
     * Creates 2 threads to increase value and prints result.
     */
    public void syncAction() {
        MySync first = new MySync();
        MySync second = new MySync();
        first.start();
        second.start();
        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(sResult);
    }
}
