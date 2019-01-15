package ru.evgenyhodz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class SimpleArray.
 *
 * @param <T> type
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @version 1.0
 * @since 27.01.2017
 */
public class SimpleArray<T> {
    /**
     * Ref to container.
     */
    protected Object[] objects;
    /**
     * Index of element in container.
     */
    protected int index = 0;

    /**
     * Constructor.
     *
     * @param size - size of the container.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Adding a new element to container.
     *
     * @param value - new element.
     */
    public void add(T value) {
        this.objects[index++] = value;
    }

    /**
     * Getting element from container by its position.
     *
     * @param position - position of element.
     * @return - element.
     * @throws NullPointerException - exception if we trying to get empty cell.
     */
    public T get(int position) throws NullPointerException {
        Object result;
        if (this.objects[position] != null) {
            result = this.objects[position];
        } else {
            throw new NullPointerException("Position is empty.");
        }
        return (T) result;
    }

    /**
     * Updates an element in the array by position.
     *
     * @param position - index of array.
     * @param value    - updating element.
     */
    public void update(int position, T value) {
        this.objects[position] = value;
    }

    /**
     * Removes element from the array.
     *
     * @param position - removing by position.
     */
    public void delete(int position) {
        List<Object> array = new ArrayList<>(Arrays.asList(this.objects));
        array.remove(position);
        this.objects = array.toArray(this.objects);
    }
}
