package ru.evgenyhodz.set;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.02.2017
 */
public class MyArraySetTest {

    @Test
    public void whenAddDuplicateThenItNotAddedTest() {
        MyArraySet<String> setList = new MyArraySet<>(10);

        String value = "value";
        String another = "another";

        setList.add(value);
        setList.add(value);
        setList.add(another);

        assertThat(setList.get(1), is(another));


    }

    @Test
    public void whenAddElementToListThenItIsNotEmpty() {
        MyArraySet<String> setList = new MyArraySet<>(10);

        String value = "value";
        setList.add(value);

        assertThat(setList.isEmpty(), is(false));
    }

    @Test
    public void whenListIsEmptyThenGetTrue() {

        MyArraySet<String> setList = new MyArraySet<>(10);

        assertThat(setList.isEmpty(), is(true));
    }

}