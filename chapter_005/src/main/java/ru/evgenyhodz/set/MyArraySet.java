package ru.evgenyhodz.set;

import ru.evgenyhodz.SimpleArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.02.2017
 */
public class MyArraySet<R> extends SimpleArray<R> implements Iterator<R>, CheckDuplication<R> {
    // Каретка :
    private int current = 0;

    /**
     * Constructor.
     *
     * @param size - size of the container.
     */
    public MyArraySet(int size) {
        super(size);
    }

    public int size() {
        return this.objects.length;
    }

    public boolean isEmpty() {
        return this.objects[0] == null;
    }

    /**
     * Adding a new element to container.
     *
     * @param value - new element.
     */
    @Override
    public void add(R value) {
        if (isEmpty()) {
            this.objects[index++] = value;
        } else if (!isDuplicate(value)) {
            this.objects[index++] = value;
        }
    }

    // Если значение - дубликат, мы его не добавим.
    /**
     * Checking if element with such value is already exist in the array.
     *
     * @param value - value to compare with.
     * @return - true/false.
     */
    @Override
    public boolean isDuplicate(R value) {
        boolean result = false;
        int index = 0;
        while (this.objects[index] != null) {
            index++;
            if (this.objects[index - 1].equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
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
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public R next() {
        R result;
        try {
            current++;
            result = (get(current - 1));
        } catch (ArrayIndexOutOfBoundsException a) {
            throw new NoSuchElementException("No more elements in list.");
        }
        return result;
    }
}
