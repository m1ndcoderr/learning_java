package ru.evgenyhodz.ms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests of difference between not synchronized and synchronized method.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.03.2017
 */
public class CountTest {
    /**
     * Not synchronized:
     */
    @Test
    public void notSyncAction() {
        Count count = new Count();
        count.notSyncAction();
        int expected = 2000000;
        assertNotEquals(count.getResult(), expected);
    }

    /**
     * Synchronized:
     */
    @Test
    public void syncAction() {
        Count count = new Count();
        count.syncAction();
        int expected = 2000000;
        assertEquals(count.getsResult(), expected);
    }

}