package ru.evgenyhodz;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @param <T> - generic.
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.01.2017
 */
public class LinkedArray<T> extends SimpleArray<T> {

    private int size = 0;

    private Node<T> first;

    private Node<T> last;

    /**
     * Constructor.
     *
     * @param size - size of the container.
     */
    public LinkedArray(int size) {
        super(size);
    }

    public void add(T value) {
        if (first == null && last == null) {
            Node node = new Node<>(null, value, null);
            last = first = node;
        } else {
            Node<T> element = last;
            last = new Node<>(element, value, null);
            element.next = last;
        }
        size++;
    }

    @Override
    public T get(int position){
        Node<T> node = first;
        if (this.size != 0 && index < this.size) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            throw new NoSuchElementException("No such element.");
        }
        return node.t;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    /**
     * Checks the list have cyclic recurrence.
     *
     * @param first - element to start check.
     * @return - true/false.
     */
    public boolean hasCycle(Node first) {
        boolean result = false;
        Node a = first, b = first;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
            if (a == b) {
                result = true;
                break;
            }
        }
        return result;
    }


    private class ListIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < size;
        }

        @Override
        public T next() {
            if (index < size) return get(index++);
            else throw new NoSuchElementException("No such element.");
        }
    }

    private static class Node<T> {

        protected T t;

        protected Node<T> next;

        protected Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.t = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
