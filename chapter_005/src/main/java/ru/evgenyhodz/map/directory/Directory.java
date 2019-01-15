package ru.evgenyhodz.map.directory;

import javafx.scene.Node;
import org.joda.time.Days;
import ru.evgenyhodz.DynamicList;

import java.util.Iterator;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 24.02.2017
 */
public class Directory<E, T> implements ElementContainer<E, T> {

    private Node<E, T>[] table;
    private final static int DEFAULT_SIZE = 100;
    private int position = 0;
    private int size;

    public Directory() {
        this.table = new Node[DEFAULT_SIZE];
        this.size = DEFAULT_SIZE;
    }

    public Directory(int size){
        this.table = new Node[DEFAULT_SIZE];
        this.size = size;
    }

    /**
     * Adding an item to container.
     *
     * @param key   - key.
     * @param value - value.
     * @return true/false.
     */
    @Override
    public boolean insert(E key, T value) {
        return false;
    }

    /**
     * Getting an item from container.
     *
     * @param key - key.
     * @return - element.
     */
    @Override
    public T get(E key) {
        return null;
    }

    /**
     * Deleting an item from container.
     *
     * @param key - key.
     * @return - true/false.
     */
    @Override
    public boolean delete(E key) {
        return false;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Element<E, T>> iterator() {
        return null;
    }


    private class Node<E, T> implements Element<E, T> {
        /**
         * Key.
         */
        private E key;
        /**
         * Value.
         */
        private T value;

        private         Node<E, T> next;

        public Node(E key, T value, Node<E, T> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /**
         * Returns key.
         *
         * @return key.
         */
        @Override
        public E getKey() {
            return this.key;
        }

        /**
         * Returns value.
         *
         * @return value.
         */
        @Override
        public T getValue() {
            return this.value;
        }
    }

    private class It implements Iterator<E>{
        private int index = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return index < position;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         //* @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            return table[index++].getKey();
        }
    }

}
