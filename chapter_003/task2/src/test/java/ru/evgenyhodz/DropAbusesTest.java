package ru.evgenyhodz;

import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Class for DropAbuses.
 *
 * @author Evgeny Khodzitskiy
 * @version 1
 * @since 21.11.2016
 */
public class DropAbusesTest {
    /**
     * Method tests that we will have output without abuse words.
     *
     * @throws IOException - input/output exceptions.
     */
    @Test
    public void whenWeHaveInputWithAbusesThenWeShouldGetOutPutWithoutThemTest() throws IOException {
        DropAbuses dropAbuses = new DropAbuses();
        String input = "Привет блин мир";
        String[] abuse = {"блин"};
        String output = "Привет  мир";
        try (ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            dropAbuses.dropAbuses(in, out, abuse);
            assertThat(out.toString(), is(output));
        }
    }
}


