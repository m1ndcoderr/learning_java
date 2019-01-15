package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Tests of "bad ways" to merge 2 sorted arrays.
 */
public class WonderfulArrayTest {
    /**
     * Test of way 1.
     */
    @Test
    public void connectionOfArrs() {
        int[] array1 = {1, 4};
        int[] array2 = {2, 5};
        int[] checked = {1, 2, 4, 5};
        WonderfulArray wonder = new WonderfulArray();
        assertThat(wonder.connectionOfArrs(array1, array2), is(checked));
    }

    /**
     * Test of way 2.
     */
    @Test
    public void connectionShortWay() {
        int[] array1 = {6, 9};
        int[] array2 = {3, 1};
        int[] checked = {1, 3, 6, 9};
        WonderfulArray fWonder = new WonderfulArray();
        assertThat(fWonder.connectionShortWay(array1, array2), is(checked));
    }

    /**
     * Test of way 3.
     */
    @Test
    public void concatArray() {
        int[] array1 = {1, 2};
        int[] array2 = {8, 3};
        int[] checked = {1, 2, 3, 8};
        WonderfulArray wonder = new WonderfulArray();
        assertThat(wonder.concatArray(array1, array2), is(checked));
    }
}