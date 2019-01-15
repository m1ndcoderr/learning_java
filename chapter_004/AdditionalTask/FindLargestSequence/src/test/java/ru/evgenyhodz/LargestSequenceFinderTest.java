package ru.evgenyhodz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Class for testing LargestSequenceFinder class and its methods to find the longest sequences
 * in simple one-dimensional array of numbers.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 22.01.2017
 */
public class LargestSequenceFinderTest {
    /**
     * Returns result of findLargestSequence(int[] array) - string value with sequence of numbers.
     */
    @Test
    public void whenTryArrayWithNumbersThenGetLongestSequence() {
        int[] numbers = {1, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 0, 7, 7, 8, 9, 99, 50, 50, 99, 7, 5};
        String result = "5, 5, 5, 5, 5, 5";
        LargestSequenceFinder lsf = new LargestSequenceFinder();
        assertThat(lsf.findLargestSequence(numbers), is(result));
    }

    /**
     * Returns result of findLargestSequence(int[] array) - ArrayIndexOutOfBoundsException.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenTryEmptyArrayThenGetExceptionClassTest() {
        int[] numbers = {};
        String result = "Array of numbers is empty.";
        LargestSequenceFinder lsf = new LargestSequenceFinder();
        assertThat(lsf.findLargestSequence(numbers), is(result));
    }

    /**
     * Returns result of findLargestSequence(int[] array) - string value with sequence of numbers.
     * If we have two sequences equal to each other - method will return the first sequence.
     */
    @Test
    public void whenTryArrayWithTwoSequencesThenGetTheFirstOneTest() {
        int[] numbers = {1, 2, 3, 3, 4, 4};
        String result = "3, 3";
        LargestSequenceFinder lsf = new LargestSequenceFinder();
        assertThat(lsf.findLargestSequence(numbers), is(result));
    }

    /**
     * Returns result of findLargestSequence(int[] array) - string value with sequence of numbers.
     * Additional test if array contains sequence of nulls.
     */
    @Test
    public void whenTryArrayWithFourNullsThenGetThemTest() {
        int[] numbers = {1, 2, 3, 3, 0, 0, 0, 0, 4, 4};
        String result = "0, 0, 0, 0";
        LargestSequenceFinder lsf = new LargestSequenceFinder();
        assertThat(lsf.findLargestSequence(numbers), is(result));
    }
}