package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Test of Square.java
 */
public class SquareTest {

    /**
     * Testing some calculate method.
     */
    @Test
    public void calculateMethodTest() {
        Square square = new Square(2, -120, 1600);
        square.calculate(5);
        assertThat(40D, is(closeTo(34D, 45D)));
    }

    /**
     * Shows the roots of expression.
     */
    @Test
    public void showMethodTest() {
        Square square = new Square(2, -120, 1600);
        square.show(1, 10, 1);
        assertThat(40D, is(closeTo(34D, 45D)));
    }
}