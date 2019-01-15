package ru.evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 20.02.2017
 */
public class MyQueueTest {

    /**
     * Checking adding element to end of queue.
     */
    @Test
    public void enqueue() {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(1);
        int result = queue.iterator().next();

        assertThat(result, is(1));
    }

    /**
     * Checking deleting element from queue.
     */
    @Test
    public void dequeue() {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(1);
        queue.dequeue();

        assertThat(queue.isEmpty(), is(true));
    }

}