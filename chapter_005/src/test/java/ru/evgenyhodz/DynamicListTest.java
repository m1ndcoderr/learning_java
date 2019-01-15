package ru.evgenyhodz;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 28.01.2017
 */
public class DynamicListTest {
    /**
     * Checking dynamic add() method.
     */
    @Test
    public void whenAddValueToFullArrayThenArrayWillBeExtendedTest() {
        DynamicList<String> list = new DynamicList<>(1);

        list.add("Value");
        list.add("More values");
        int result = list.size();

        assertThat(result, is(2));
    }

    /**
     * Checking size getter.
     */
    @Test
    public void whenGetSizeThenReturnsSizeTest() {
        DynamicList<String> list = new DynamicList<>(1);

        int result = list.size();

        assertThat(result, is(1));
    }

    /**
     * Checking hasNext()
     */
    @Test
    public void whenWeCheckHasNextThenReturnBoolean() {
        DynamicList<String> list = new DynamicList<>(1);

        list.add("Value");
        // Текущий элемент = 0, а следующего нет. Значит false:
        assertThat(list.hasNext(), is(false));

    }

    /**
     * Checking next()
     */
    @Test
    public void whenWeWantToGetCurrentElementFromArrayThenGetItTest() {
        DynamicList<String> list = new DynamicList<>(1);

        list.add("Value");
        String result = list.next();

        assertThat(result, is("Value"));

    }

    /**
     * Checking next()
     */
    @Test(expected = NoSuchElementException.class)
    public void whenWeWantToGetCurrentElementFromArrayThenGetFailTest() {
        DynamicList<String> list = new DynamicList<>(1);

        list.add("Value");
        list.next();
        String result = list.next();

        assertThat(result, is("Value"));

    }

}