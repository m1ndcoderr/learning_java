package ru.evgenyhodz;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 30.01.2017
 */
public class ArrayConverterTest {
    /**
     * Checking convert method. 2D array to 1D array.
     */
    @Test
    public void whenTryNextThenGetCurrentValueAndMoveToNextIndexTest() {
        int values[][] = {
                {1, 2},
                {3, 4}
        };
        ArrayConverter arrayConverter = new ArrayConverter(values);

        assertThat(arrayConverter.next(), is(1));
        assertThat(arrayConverter.next(), is(2));
        assertThat(arrayConverter.next(), is(3));
        assertThat(arrayConverter.next(), is(4));
    }

    /**
     * Throws exception then reaches the end of array.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenReachedEndOfArrayThenGetExceptionTest() {
        int values[][] = {
                {1, 2},
                {3, 4}
        };
        ArrayConverter arrayConverter = new ArrayConverter(values);

        assertThat(arrayConverter.next(), is(1));
        assertThat(arrayConverter.next(), is(2));
        assertThat(arrayConverter.next(), is(3));
        assertThat(arrayConverter.next(), is(4));
        assertThat(arrayConverter.next(), is(4));

    }

}