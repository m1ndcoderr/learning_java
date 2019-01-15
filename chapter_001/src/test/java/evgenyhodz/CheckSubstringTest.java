package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class.
 */
public class CheckSubstringTest {
    /**
     * Check the work of contains() that check of substring if a part of origin string.
     */
    @Test
    public void containsTest() {
        String origin = "Hello world!";
        String sub = "world!";
        CheckSubstring obj = new CheckSubstring();
        assertThat(obj.contains(origin, sub), is(true));
    }
}