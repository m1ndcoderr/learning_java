package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Test of searching of max value of three.
 */
public class MaxSideTest {
    /**
     * Trying to find max side of triangle.
     */
    @Test
    public void searchOfMaxSideOfObject() {
        MaxSide side = new MaxSide();
        side.findMaxSide(13.23, 35.0, 23.23);
        assertThat(35D, is(closeTo(34D, 36D)));
    }
}