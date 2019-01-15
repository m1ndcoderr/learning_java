package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test of merging of 2 sorted arrays into one sorted array.
 */
public class MergeArrayTest {
    /**
     * Test of merging of 2 sorted arrays into one sorted array.
     */
    @Test
    public void merge() {
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6};
        int[] checked = {1, 2, 3, 4, 5, 6, 7};
        MergeArray arr = new MergeArray();
        assertThat(arr.merge(array1, array2), is(checked));
    }
}