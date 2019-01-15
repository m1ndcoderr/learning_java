package evgenyhodz;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test class.
 */
public class RemoveDuplicatesTest {
    /**
     * Test method. Trying to remove duplicate values from a string.
     */
    @Test
    public void RemovingDupsTest() {
        RemoveDuplicates testArr = new RemoveDuplicates();
        String[] arr = {"Anton", "Anton", "Vasiliy", "Vasiliy", "Kolyan", "Kolyan"};
        String[] checked = {"Anton", "Vasiliy", "Kolyan"};
        String[] result = testArr.rmDuplicates(arr);
        assertThat(result, is(checked));
    }
}