package ru.evgenyhodz;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 03.02.2017
 */
public class IteratorNextTest {
    /**
     * Reference to iterator of iterators.
     */
    private List<Iterator<Integer>> itList;

    /**
     * Constants for test (created because of checkstyle magic number failures).
     */
    private static final int THREE = 3,
            FOUR = 4;

    /**
     * Creating iterator of iterators and object of class itconverter.
     */
    @Before
    public void createFolded() {
        List<Integer> firstSequence = new LinkedList<>(Arrays.asList(1, 2));
        List<Integer> secondSequence = new LinkedList<>(Arrays.asList(THREE, FOUR));
        itList = new LinkedList<>(Arrays.asList(firstSequence.iterator(), secondSequence.iterator()));
    }

    /**
     * ENG:
     * Compares two strings. First string is a string of method result,
     * second string is a string made from to-check iterator with an equal sequence.
     * RUS:
     * Сравнивает две строки: первая строка - последовательность итератора, который
     * получился в результате convert(), вторая - последовательность проверочного итератора.
     */
    @Test
    public void whenConvertFoldedIteratorWhenGetUnitedSequenceTest() {
        IteratorNext iteratorNext = new IteratorNext(itList.iterator());

        int result1 = iteratorNext.next();
        int result2 = iteratorNext.next();
        int result3 = iteratorNext.next();
        int result4 = iteratorNext.next();
        // int result5 = iteratorNext.next();

        assertThat(result1, is(1));
        assertThat(result2, is(2));
        assertThat(result3, is(3));
        assertThat(result4, is(4));
        //  assertThat(result5, is(5));
    }
}