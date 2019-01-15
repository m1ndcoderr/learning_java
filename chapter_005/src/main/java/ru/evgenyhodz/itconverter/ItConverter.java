package ru.evgenyhodz.itconverter;

import com.google.common.collect.Iterators;

import java.util.Iterator;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.01.2017
 */
class ItConverter implements IteratorsConverter {
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
        return Iterators.concat(it);
    }
}
