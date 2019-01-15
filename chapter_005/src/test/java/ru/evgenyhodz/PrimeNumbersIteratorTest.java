package ru.evgenyhodz;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.01.2017
 */
public class PrimeNumbersIteratorTest {
    /**
     * ENG:
     * Constant for test.
     * RUS:
     * Константа для теста.
     */
    private static final int TWELVE = 12;
    /**
     * ENG:
     * Constant for test.
     * RUS:
     * Константа для теста.
     */
    private static final int THIRTEEN = 13;
    /**
     * ENG:
     * Constant for test.
     * RUS:
     * Константа для теста.
     */
    private static final int FOURTEEN = 14;

    /**
     * ENG:
     * When all numbers in the int[] are not prime, then we will get false.
     * RUS:
     * Когда все числа в массиве не простые - результат false.
     */
    @Test
    public void whenWeHaveNotGotPrimeNumbersThenWillGetFalseTest() {
        PrimeNumbersIterator primeNumbersIterator = new PrimeNumbersIterator(new int[]{TWELVE, FOURTEEN});

        primeNumbersIterator.hasNext();
        boolean result = primeNumbersIterator.hasNext();

        assertThat(result, is(false));
    }

    /**
     * ENG:
     * When nex[ number in the int[] is not prime, then we will get false.
     * RUS:
     * Когда следующее число в массиве не простое - результат false.
     */
    @Test
    public void whenNextNumberNotPrimeThenWillGetFalseTest() {
        PrimeNumbersIterator primeNumbersIterator = new PrimeNumbersIterator(new int[]{THIRTEEN, FOURTEEN});

        primeNumbersIterator.hasNext();
        boolean result = primeNumbersIterator.hasNext();

        assertThat(result, is(false));
    }

    /**
     * ENG:
     * When all numbers in the int[] are not prime, then we will get false.
     * RUS:
     * Когда все числа в массиве не простые - результат false.
     */
    @Test
    public void whenWeHavePrimeNumberThenWillGetTrueTest() {
        PrimeNumbersIterator primeNumbersIterator = new PrimeNumbersIterator(new int[]{TWELVE, THIRTEEN});

        primeNumbersIterator.hasNext();
        boolean result = primeNumbersIterator.hasNext();

        assertThat(result, is(true));
    }

    /**
     * ENG:
     * Test of getting next prime number in the int[] array.
     * RUS:
     * Вызывая next(), должны получить следующее простое число.
     */
    @Test
    public void whenGetNextCallThenGetPrimeNumberTest() {
        PrimeNumbersIterator primeNumbersIterator = new PrimeNumbersIterator(new int[]{TWELVE, THIRTEEN});

        primeNumbersIterator.next();
        int result = (Integer) primeNumbersIterator.next();

        assertThat(result, is(THIRTEEN));
    }

    /**
     * ENG:
     * Test of getting next prime number in the int[] array.
     * Because there are no prime numbers in the array here, we will get an exception.
     * RUS:
     * Вызывая next(), должны получить следующее простое число. Так как у нас нет простых чисел в
     * этом тесте, мы получим исключение, тест будет пропущен.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenGetNextCallThenGetExceptionTest() {
        PrimeNumbersIterator primeNumbersIterator = new PrimeNumbersIterator(new int[]{TWELVE, FOURTEEN});

        primeNumbersIterator.next();
        int result = (Integer) primeNumbersIterator.next();

        assertThat(result, is(FOURTEEN));
    }

}