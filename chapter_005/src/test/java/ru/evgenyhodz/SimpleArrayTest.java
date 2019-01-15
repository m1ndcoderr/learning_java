package ru.evgenyhodz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 27.01.2017
 */
public class SimpleArrayTest {
    /**
     * ENG:
     * Constant for test.
     * RUS:
     * Константа для теста.
     */
    private static final int SIZE = 1;
    /**
     * Ref to tested class.
     */
    private SimpleArray<String> simpleArray;
    /**
     * Ref to some value for container.
     */
    private String text;
    /**
     * Another reference.
     */
    private String anotherText;

    /**
     * Creating container and objects for tests.
     */
    @Before
    public void create() {
        simpleArray = new SimpleArray<>(SIZE);
        text = "Success";
        anotherText = "Victory";
    }

    /**
     * Checking of add() method.
     */
    @Test
    public void add() {
        simpleArray.add(text);
        assertThat(simpleArray.get(0), is("Success"));
    }

    /**
     * Checking of get(int position) method.
     * Throws exception because container is empty.
     */
    @Test(expected = NullPointerException.class)
    public void get() {
        assertThat(simpleArray.get(0), is("null"));
    }

    /**
     * Checking of update(int position, T value) method.
     */
    @Test
    public void update() {
        simpleArray.add(text);
        simpleArray.update(0, anotherText);
        assertThat(simpleArray.get(0), is("Victory"));

    }

    /**
     * Checking delete(int position) method.
     * Throws exception, because we deleted value from container,
     * and because method get() throws exception if position is empty.
     */
    @Test(expected = NullPointerException.class)
    public void delete() {
        simpleArray.add(text);
        simpleArray.delete(0);
        assertThat(simpleArray.get(0), is("null"));
    }

}