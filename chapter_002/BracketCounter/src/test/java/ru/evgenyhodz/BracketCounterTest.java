package ru.evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class of BracketCounter.
 *
 * @author Evgeny Khodzitskiy.
 */
public class BracketCounterTest {
    /**
     * Test if we have correctly spaced brackets.
     */
    @Test
    public void whenWeCountBracketsThenWeWillGetTrueOrFalseTest() {
        BracketCounter bracketCounter = new BracketCounter();
        String s = "(1 + 1) - (2 - 1) = 1.";
        assertThat(bracketCounter.checkBrackets(s), is(true));
    }

    /**
     * Test of not correctly spaced brackets.
     */
    @Test
    public void whenWeCheckStringWithBracketsThenWeGetErrorTest() {
        BracketCounter bracketCounter = new BracketCounter();
        String s = "(1 + 1() - )2 - 1) = 1.";
        assertThat(bracketCounter.checkBrackets(s), is(false));
    }
}
