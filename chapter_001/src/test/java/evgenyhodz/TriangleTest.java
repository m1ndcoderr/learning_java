package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test of Triangle.java methods.
 */
public class TriangleTest {
    /**
     * Checking the work of method that shows if triangle can exist.
     */
    @Test
    public void searchOfTriangleExistence() {
        Triangle triangle = new Triangle(new Point(1, 1), new Point(3, 5), new Point(2, 7));
        assertThat(triangle.existence(), is(true));
    }

    /**
     * Checking the work of method that shows if triangle can exist.
     */
    @Test
    public void searchOfTriangleExistence2() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(0, 0), new Point(0, 0));
        assertThat(triangle.existence(), is(false));
    }

    /**
     * Checking the work of method that shows if triangle can exist.
     */
    @Test
    public void searchOfTriangleExistence3() {
        Triangle triangle = new Triangle(new Point(2, 2), new Point(2, 2), new Point(3, 5));
        assertThat(triangle.existence(), is(false));
    }

    /**
     * Test of the method calculating the area of ​​a triangle using Heron's formula.
     */
    @Test
    public void searchOfTriangleSquare() {
        Triangle triangle = new Triangle(new Point(1, 1), new Point(3, 5), new Point(2, 7));
        assertThat(triangle.area(), is(3.999999999999998));
    }
}