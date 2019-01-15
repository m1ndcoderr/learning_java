package ru.evgenyhodz.ms;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 23.03.2017
 */
public class SyncLinkedList<E> {
    /**
     * Number of elements in this list.
     */
    private int size = 0;
    /**
     * Index.
     */
    private int index = 0;
    /**
     * Ref to first element in the list.
     */
    private Node<E> first;
    /**
     * Ref to last element in the list.
     */
    private Node<E> last;

    /**
     * Constructor.
     *
     * @param size - size of the container.
     */
    public SyncLinkedList(int size) {
        this.size = size;
    }

    public synchronized void add(E value) {
        if (first == null && last == null) {
            Node node = new Node<>(null, value, null);
            last = first = node;
        } else {
            Node<E> element = last;
            last = new Node<>(element, value, null);
            element.next = last;
        }
        size++;
    }

    public synchronized E get(int position) {
        Node<E> node = first;
        if (this.size != 0 && index < this.size) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            throw new NoSuchElementException("No such element.");
        }
        return node.t;
    }

    /**
     * Returns size of the list.
     *
     * @return size.
     */
    public synchronized int getSize() {
        return size;
    }

    public synchronized Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < size;
        }

        @Override
        public E next() {
            if (index < size) return get(index++);
            else throw new NoSuchElementException("No such element.");
        }
    }

    private static class Node<E> {

        private E t;

        private Node<E> next;

        private Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.t = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
