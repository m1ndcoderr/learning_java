package ru.evgenyhodz;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.01.2017
 */
class PrimeNumbersIterator implements Iterator {
    /**
     * Special variable for methods.
     */
    private static final int SPECIAL = 3;
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
    PrimeNumbersIterator(final int[] numbers) {
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
        boolean result = true;
        for (int i = index + 1; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                result = false;
            } else {
                for (int j = SPECIAL; j * j <= values[i]; j += 2) {
                    if (values[i] % j == 0) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Returns the next prime number in the iteration.
     *
     * @return the next prime number in the iteration
     * @throws NoSuchElementException if the iteration has no more prime numbers
     */
    @Override
    public Object next() throws NoSuchElementException {
        int result = 0;
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 != 0) {
                for (int j = SPECIAL; j * j <= values[i]; j += 2) {
                    if (values[i] % j != 0) {
                        result = values[i];
                        index++;
                        break;
                    }
                }
            }
        }
        if (result == 0) {
            throw new NoSuchElementException("There is no prime numbers in the array.");
        }
        return result;
    }
}

