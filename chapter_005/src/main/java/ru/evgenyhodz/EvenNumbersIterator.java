package ru.evgenyhodz;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 24.01.2017
 */
class EvenNumbersIterator implements Iterator {
    /**
     * Array with int values.
     */
    private final int[] values;
    /**
     * Index of array's cells.
     */
    private int index = 0;

    /**
     * Constructor.
     *
     * @param numbers - array with numbers.
     */
    EvenNumbersIterator(final int[] numbers) {
        this.values = numbers;
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
        for (int i = index + 1; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Returns the next even element in the iteration.
     *
     * @return the next even element in the iteration
     * @throws NoSuchElementException if the iteration has no more even elements
     */
    @Override
    public Object next() throws NoSuchElementException {
        int result = 0;
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                result = values[i];
                index++;
                break;
            }
        }
        if (result == 0) {
            throw new NoSuchElementException("There is no even numbers in the array.");
        }
        return result;
    }
}

