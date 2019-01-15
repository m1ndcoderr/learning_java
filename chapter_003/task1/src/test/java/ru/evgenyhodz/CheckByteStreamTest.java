package ru.evgenyhodz;

import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Class for checking if even number is in stream.
 *
 * @author Evgeny Khodzitskiy
 * @version 1
 * @since 21.11.2016
 */
public class CheckByteStreamTest {

    /**
     * Test for checking if we have even num in stream we should get true.
     */
    @Test
    public void whenWeEnterEvenNumberThenWeWillGetTrueTest() {
        CheckByteStream checkByteStream = new CheckByteStream();
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("10".getBytes())) {
            assertThat(checkByteStream.isNumber(byteArrayInputStream), is(true));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * Test for checking if we don't have even num in stream we should get false.
     */
    @Test
    public void whenWeEnterOddNumberThenWeWillGetFalseTest() {
        CheckByteStream checkByteStream = new CheckByteStream();
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("7".getBytes())) {
            assertThat(checkByteStream.isNumber(byteArrayInputStream), is(false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

