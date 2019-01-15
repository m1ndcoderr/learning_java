package ru.evgenyhodz.wn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.03.2017
 */
public class ProducerCustomer {

    //private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    private final Queue<Integer> queue = new LinkedList<>();

    private void producer() throws InterruptedException {
        synchronized (this.queue) {
            queue.add(new AtomicInteger(1).get());
            this.queue.notify();
            System.out.println(Thread.currentThread().getName() + " add new Atomic Integer.");
        }
    }

    private void consumer() throws InterruptedException {
        synchronized (this.queue) {
            while (this.queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " is waiting.");
                this.queue.wait();
            }
            System.out.println(String.format("Consumer working: %s, number from queue: %s",
                    Thread.currentThread().getName(), this.queue.poll()));
        }
    }


    private void init() throws InterruptedException {
        Thread first = new Thread(() -> {
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread second = new Thread(() -> {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        first.start();
        second.start();
        first.join();
        second.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new ProducerCustomer().init();
    }
}
