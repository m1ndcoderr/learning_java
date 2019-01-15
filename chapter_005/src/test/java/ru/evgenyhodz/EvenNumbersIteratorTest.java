package ru.evgenyhodz;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 24.01.2017
 */
public class EvenNumbersIteratorTest {
    /**
     * ENG:
     * Constant for test.
     * RUS:
     * Константа для теста.
     */
    private static final int ONE = 1;
    /**
     * ENG:
     * Constant for test.
     * RUS:
     * Константа для теста.
     */
    private static final int TWO = 2;
    /**
     * ENG:
     * Constant for test.
     * RUS:
     * Константа для теста.
     */
    private static final int THREE = 3;
    /**
     * ENG:
     * Constant for test.
     * RUS:
     * Константа для теста.
     */
    private static final int FOUR = 4;

    /**
     * ENG:
     * When numbers in the int[] are only odd, then we will get false.
     * RUS:
     * Когда все числа в массиве нечетные - результат false.
     */
    @Test
    public void whenWeHaveOddNumberThenWillGetFalseTest() {
        EvenNumbersIterator evenNumbersIterator = new EvenNumbersIterator(new int[]{ONE, THREE});

        evenNumbersIterator.hasNext();
        boolean result = evenNumbersIterator.hasNext();

        assertThat(result, is(false));
    }

    /**
     * ENG:
     * When we have an even number in the array then we will get true.
     * RUS:
     * Проверяем, есть ли четное число в массиве и получаем true.
     */
    @Test
    public void whenWeHaveEvenNumberThenGetTrueTest() {
        EvenNumbersIterator evenNumbersIterator = new EvenNumbersIterator(new int[]{ONE, TWO});

        evenNumbersIterator.hasNext();
        boolean result = evenNumbersIterator.hasNext();

        assertThat(result, is(true));
    }

    /**
     * ENG:
     * Test of getting next even number in the int[] array.
     * RUS:
     * Вызывая next(), должны получить следующее четное число.
     */
    @Test
    public void whenGetNextCallThenGetEvenNumberTest() {
        EvenNumbersIterator evenNumbersIterator = new EvenNumbersIterator(new int[]{ONE, FOUR});

        evenNumbersIterator.next();
        int result = (Integer) evenNumbersIterator.next();

        assertThat(result, is(FOUR));
    }

    /**
     * ENG:
     * Test of getting next even number in the int[] array.
     * Because there are no even numbers in the array here, we will get an exception.
     * RUS:
     * Вызывая next(), должны получить следующее четное число. Так как у нас нет четных чисел в
     * этом тесте, мы получим исключение, тест будет пропущен.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenGetNextCallThenGetExceptionTest() {
        EvenNumbersIterator evenNumbersIterator = new EvenNumbersIterator(new int[]{ONE, THREE});

        evenNumbersIterator.next();
        int result = (Integer) evenNumbersIterator.next();

        assertThat(result, is(FOUR));
    }

}