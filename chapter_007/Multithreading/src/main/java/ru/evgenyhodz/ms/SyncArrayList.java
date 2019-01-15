package ru.evgenyhodz.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 23.03.2017
 */
public class SyncArrayList<E> {
    /**
     * Reference to container.
     */
    protected Object[] objects;
    /**
     * Index of element in container.
     */
    protected int index = 0;

    /**
     * Pointer.
     */
    private int current = 0;

    /**
     * Default array size.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Default constructor.
     */
    public SyncArrayList() {
        this.objects = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructor.
     *
     * @param size - size of the container.
     */
    public SyncArrayList(int size) {
        this.objects = new Object[size];
    }

    /**
     * Adding a new element to container.
     *
     * @param value - new element.
     */
    public synchronized void add(E value) {
        if (index == size()) {
            Object[] biggerArray = new Object[size() + 1];
            System.arraycopy(objects, 0, biggerArray, 0, size());
            objects = biggerArray;
            objects[index++] = value;
        } else {
            objects[index++] = value;
        }
    }

    /**
     * Returns array's length.
     *
     * @return int value.
     */
    public synchronized int size() {
        return objects.length;
    }

    /**
     * Getting element from container by its position.
     *
     * @param position - position of element.
     * @return - element.
     * @throws NullPointerException - exception if we trying to get empty cell.
     */
    public synchronized E get(int position) throws NullPointerException {
        Object result;
        if (this.objects[position] != null) {
            result = this.objects[position];
        } else {
            throw new NullPointerException("Position is empty.");
        }
        return (E) result;
    }

    /**
     * Updates an element in the array by position.
     *
     * @param position - index of array.
     * @param value    - updating element.
     */
    public synchronized void update(int position, E value) {
        this.objects[position] = value;
    }

    /**
     * Removes element from the array.
     *
     * @param position - removing by position.
     */
    public synchronized void delete(int position) {
        List<Object> array = new ArrayList<>(Arrays.asList(this.objects));
        array.remove(position);
        this.objects = array.toArray(this.objects);
    }

    /**
     * Returns boolean if we have (or don't have) next element in the array.
     *
     * @return boolean.
     */
    public synchronized boolean hasNext() {
        boolean result = false;
        try {
            if (this.objects[current + 1] != null) {
                result = true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            result = false;
        }
        return result;
    }

    /**
     * Returns next element from array.
     *
     * @return T value.
     */
    public synchronized E next() {
        E result;
        try {
            current++;
            result = (get(current - 1));
        } catch (ArrayIndexOutOfBoundsException a) {
            throw new NoSuchElementException("No more elements in list.");
        }
        return result;
    }
}
