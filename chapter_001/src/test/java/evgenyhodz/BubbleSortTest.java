package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class checks that API works.
 */
public class BubbleSortTest {
    /**
     * Checking bubble sort with mixed numbers.
     */
    @Test
    public void bubbleTestMixedValues() {
        int[] array = {2, 5, 1, 8, 12, 3, 7};
        int[] checked = {1, 2, 3, 5, 7, 8, 12};
        BubbleSort test = new BubbleSort();
        test.sort(array);
        assertThat(array, is(checked));
    }

    /**
     * Checking bubble sort with decreasing values.
     */
    @Test
    public void bubbleTestDecreasingValues() {
        int[] array = {4, 3, 2, 1};
        int[] checked = {1, 2, 3, 4};
        BubbleSort test = new BubbleSort();
        test.sort(array);
        assertThat(array, is(checked));
    }

    /**
     * Checking bubble sort with duplicate values.
     */
    @Test
    public void bubbleTestDecreasingWithDups() {
        int[] array = {4, 3, 2, 1, 2, 3, 2};
        int[] checked = {1, 2, 2, 2, 3, 3, 4};
        BubbleSort test = new BubbleSort();
        test.sort(array);
        assertThat(array, is(checked));
    }
}