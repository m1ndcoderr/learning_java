package ru.evgenyhodz.wn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 27.03.2017
 */
public class ThreadPool {

    private final int cores = Runtime.getRuntime().availableProcessors();

    private BlockingQueue<Thread> threadPool = new ArrayBlockingQueue<>(this.cores);

    public ThreadPool() {
        for (int i = 0; i < threadPool.size(); i++) {
            threadPool.add(new Work());
        }
    }

    private void add(Work work) {
        this.threadPool.add(work);
        System.out.println("new Work added by: " + Thread.currentThread().getName());
    }

    private void action() {
        try {
            this.threadPool.take().start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread working: " + Thread.currentThread().getName());
    }

    /**
     *
     */
    private void init() {
        ThreadPool threadPool = new ThreadPool();
        Thread first = new Thread(() -> {
            threadPool.add(new Work());
        });
        Thread second = new Thread(threadPool::action);
        first.start();
        second.start();
    }

    private class Work extends Thread {
        @Override
        public void run() {
            System.out.println("Thread executing this work is: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        new ThreadPool().init();

    }
}
