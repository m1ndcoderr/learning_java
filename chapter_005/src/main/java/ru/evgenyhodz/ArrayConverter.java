package ru.evgenyhodz;

import java.util.NoSuchElementException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 31.01.2017
 */
public class ArrayConverter {
    private final int[][] values;
    private int upper = 0;
    private int lower = 0;

    /**
     * Constructor.
     *
     * @param values - array with data.
     */
    public ArrayConverter(int[][] values) {
        this.values = values;
    }

    /**
     * Return current values, move point to next.
     *
     * @return - values of inner arrays.
     */
    public int next() throws NoSuchElementException {
        if (lower >= values[upper].length) {
            upper++;
            lower = 0;
        }
        if (upper >= values.length) {
            throw new NoSuchElementException("Reached end");
        }
        return values[upper][lower++];
    }
}
