package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Testing of method to find factorial.
 */
public class FactorialTest {
    /**
     * Factorial of 0.
     */
    @Test
    public void gettingOfFactorial1() {
        Factorial fact = new Factorial();
        assertThat(fact.getFac(0), is(1));
    }

    /**
     * Factorial of 8.
     */
    @Test
    public void gettingOfFactorial2() {
        Factorial fact = new Factorial();
        assertThat(fact.getFac(8), is(40320));
    }

    /**
     * Factorial of negative number.
     * Factorial cannot be negative and we'll get the exception. Test will be skipped.
     * Факториал не может быть отрицательным, поэтому мы получим исключение. Тест будет пропущен.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenNIsNegative() throws Exception {
        Factorial fact = new Factorial();
        String message = "The value of num cannot be negative";
        assertThat(fact.getFac(-1), is(message));
    }
}