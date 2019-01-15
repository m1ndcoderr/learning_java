package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class of Point.java
 */
public class PointTest {
    /**
     * Test method. Trying to find distance between two points.
     */
    @Test
    public void searchOfDistanceBetweenTwoPoints() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(2, 2);
        assertThat(point1.distanceTo(point2), is(1.4142135623730951));
    }
}