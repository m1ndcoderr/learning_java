package ru.evgenyhodz.itconverter;

import com.google.common.base.Joiner;
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
 * @since 28.01.2017
 */
public class AnotherConverterTest {
    /**
     * Reference.
     */
    private Iterator<Integer> firstSequence;
    /**
     * Reference.
     */
    private Iterator<Integer> secondSequence;
    /**
     * Reference.
     */
    private Iterator<Integer> thirdSequence;
    /**
     * Constants for test (created because of checkstyle magic number failures).
     */
    private static final int THREE = 3,
            FOUR = 4,
            FIVE = 5,
            SIX = 6,
            SEVEN = 7,
            EIGHT = 8,
            NINE = 9;

    /**
     * Creating iterator of iterators and object of class itconverter.
     */
    @Before
    public void createFolded() {
        firstSequence = Arrays.asList(1, 2, THREE).iterator();
        secondSequence = Arrays.asList(FOUR, FIVE, SIX).iterator();
        thirdSequence = Arrays.asList(SEVEN, EIGHT, NINE).iterator();
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
    public void whenConvertFoldedIteratorWhenGetUnitedTest() {
        List<Integer> sequence = new LinkedList<>(Arrays.asList(
                1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE)
        );
        AnotherConverter anotherConverter = new AnotherConverter(firstSequence, secondSequence, thirdSequence);
        String result = Joiner.on(", ").join(anotherConverter.convert(anotherConverter));
        String check = Joiner.on(", ").join(sequence.iterator());
        assertThat(result, is(check));
    }

}