package ru.evgenyhodz;

import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 18.01.2017
 */
public class InputTest {
    /**
     * Result of test whenInpNumThenGetItBackTest().
     */
    private static final int NUMBER = 6;
    /**
     * Check of user's input of numbers.
     * All numbers decreased by 1 for user's comfort,
     * because all array indexes starts from 0.
     */
    @Test
    public void whenInputNumberThenGetItBackTest() {
        Input input = new Input();
        String number = "2";
        assertThat(input.input(new Scanner(number)), is(1));
    }

    /**
     * Check of user's input of numbers.
     * All numbers decreased by 1 for user's comfort,
     * because all array indexes starts from 0.
     */
    @Test
    public void whenInpNumThenGetItBackTest() {
        Input input = new Input();
        String number = "6";
        assertThat(input.inputFieldSize(new Scanner(number)), is(NUMBER));
    }
}