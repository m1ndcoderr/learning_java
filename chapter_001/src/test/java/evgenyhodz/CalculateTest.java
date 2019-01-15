package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class to test methods of Calculate.
 */
public class CalculateTest {
    /**
     * Test of addition.
     */
    @Test
    public void whenSetAddThenReturnResult() {
        Calculate calculate = new Calculate();
        calculate.add(1D, 1D);
        assertThat(calculate.getResult(), is(2D));
    }

    /**
     * Test of submission.
     */
    @Test
    public void whenSetSubThenReturnResult() {
        Calculate calculate = new Calculate();
        calculate.sub(2D, 1D);
        assertThat(calculate.getResult(), is(1D));
    }

    /**
     * Test of multiplication.
     */
    @Test
    public void whenSetMulThenReturnResult() {
        Calculate calculate = new Calculate();
        calculate.mul(4D, 5D);
        assertThat(calculate.getResult(), is(20D));
    }

    /**
     * Test of division.
     */
    @Test
    public void whenSetDivThenReturnResult() {
        Calculate calculate = new Calculate();
        calculate.div(4D, 2D);
        assertThat(calculate.getResult(), is(2D));
    }
}