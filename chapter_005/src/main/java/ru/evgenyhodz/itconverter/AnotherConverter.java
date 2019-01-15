package ru.evgenyhodz.itconverter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 27.01.2017
 */
class AnotherConverter implements Iterator, IteratorsConverter {
    /**
     * Array of Iterators of Integer.
     */
    private Iterator<Integer>[] horror;
    /**
     * Current position in the array.
     */
    private int current;

    /**
     * Constructor.
     * @param data - array of Iterators of Integer.
     */
    @SafeVarargs
    AnotherConverter(Iterator<Integer>... data) {
        this.horror = data;
        current = 0;
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
        while (current < horror.length && !horror[current].hasNext()) {
            current++;
        }
        return current < horror.length;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() throws NoSuchElementException {
        Object result = null;
        while (current < horror.length && !horror[current].hasNext()) {
            result = horror[current].next();
            current++;
        }
        if (result == null) {
            throw new NoSuchElementException("No data in iterators.");
        }
        return result;
    }

    /**
     * Returns folded iterator.
     *
     * @param it - iterator of iterators, each iterator is a sequence, for example, like:
     *           Iterator 1 - 4204649,
     *           Iterator 2 - 09875,
     *           Iterator 3 - 135670984.
     *           Iterator<Iterator<Integer> - ((4 2 0 4 6 4 9), (0 9 8 7 5), (1 3 5 6 7 0 9 8 4)).
     * @return folded iterator, like Iterator<Integer> - (4 2 0 4 6 4 9 0 9 8 7 5 1 3 5 6 7 0 9 8 4).
     */
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        List<Integer> iterator = new ArrayList<>();
        Integer result;
        while (it.hasNext()) {
            while (horror[current].hasNext()) {
                result = horror[current].next();
                iterator.add(result);
            }
        }
        return iterator.iterator();
    }
}
