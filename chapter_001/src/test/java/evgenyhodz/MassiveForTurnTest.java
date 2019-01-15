package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Tests of rotation of 2-dimensional arrays.
 */
public class MassiveForTurnTest {
    /**
     * Transposition of array.
     */
    @Test
    public void wowTranspositionMethodTest() {
        int[][] values = {{1, 2}, {3, 4}};
        int[][] checked = {{1, 3}, {2, 4}};
        MassiveForTurn obj = new MassiveForTurn(values);
        obj.wowTransposition(values);
        assertThat(values, is(checked));

    }

    /**
     * Rotate array to the left.
     */
    @Test
    public void rotateByNinetyToLeftTEST() {
        int[][] values = {{1, 2}, {3, 4}};
        int[][] checked = {{2, 4}, {1, 3}};
        MassiveForTurn obj = new MassiveForTurn(values);
        obj.rotateByNinetyToLeft(values);
        assertThat(values, is(checked));
    }

    /**
     * Rotate array to the right.
     */
    @Test
    public void rotateByNinetyToRightTEST() {
        int[][] values = {{1, 2}, {3, 4}};
        int[][] checked = {{3, 1}, {4, 2}};
        MassiveForTurn obj = new MassiveForTurn(values);
        obj.rotateByNinetyToRight(values);
        assertThat(values, is(checked));
    }
}