package ru.evgenyhodz;

import java.util.Iterator;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 19.02.2017
 */
public class MyQueue<T> {

    private Node first;

    private Node last;

    private int num;

    private class Node {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null || num == 0;
    }

    private int size() {
        return num;
    }

    // Добавление элемента в конец очереди.
    public void enqueue(T element) {
        Node old = last;
        last = new Node();
        last.item = element;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            old.next = last;
        }
        num++;
    }

    // Убираем элемент из начала очереди.
    public T dequeue() {
        T t = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        num--;
        return t;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T t = (T) current.item;
            current = current.next;
            return t;
        }
    }

}
