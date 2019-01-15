package ru.evgenyhodz;

import java.util.NoSuchElementException;

/**
 * @param <T> - generic.
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 28.01.2017
 */
public class DynamicList<T> extends SimpleArray<T> {

    // Указатель (каретка) :
    private int current = 0;

    /**
     * Constructor.
     *
     * @param size - size of the container.
     */
    public DynamicList(int size) {
        super(size);
    }


    public int size() {
        return objects.length;
    }


    /**
     * Adding a new element to container.
     *
     * @param value - new element.
     */
    @Override
    public void add(T value) {
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
     * Returns boolean if we have (or don't have) next element in the array.
     *
     * @return boolean.
     */
    public boolean hasNext() {
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
    public T next() {
        T result;
        try {
            current++;
            result = (get(current - 1));
        } catch (ArrayIndexOutOfBoundsException a) {
            throw new NoSuchElementException("No more elements in list.");
        }
        return result;
    }
}
