package ru.evgenyhodz;

import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Tests of user's input.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 23.12.2016
 */
public class UserInputTest {
    /**
     * Test of input method. If we print "10", result should be "10".
     */
    @Test
    public void whenTypeNumbersThenGetTheResult() throws Exception {
        UserInput input = new UserInput();
        Scanner scanner = new Scanner("10");
        assertThat(input.input(scanner), is(10d));
    }

    /**
     * Test of ask method. If we print "y", result should be "y".
     */
    @Test
    public void ask() {
        UserInput input = new UserInput();
        Scanner scanner = new Scanner("y");
        assertThat(input.ask("Exit?", scanner), is("y"));
    }

}