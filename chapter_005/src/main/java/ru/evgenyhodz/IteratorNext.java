package ru.evgenyhodz;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 03.02.2017
 */
public class IteratorNext {

    private Iterator<Iterator<Integer>> values = null;
    private Iterator<Integer> current;

    public IteratorNext(Iterator<Iterator<Integer>> iterator) {
        this.values = iterator;
    }

    /**
     * Return current values, move point to next.
     *
     * @return - values of inner arrays.
     */
    public int next() throws NoSuchElementException {
        int result = -1;
        if (current != null && current.hasNext()) {
            result = current.next();
        } else if (values != null && values.hasNext()) {
            current = values.next();
            if (current.hasNext()) {
                result = current.next();
            }
        } else {
            throw new NoSuchElementException("Reached end");
        }
        return result;
    }
}
