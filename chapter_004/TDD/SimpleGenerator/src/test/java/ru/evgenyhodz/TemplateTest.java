package ru.evgenyhodz;

import org.junit.Before;
import org.junit.Test;

import java.security.KeyException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 08.01.2017
 */
public class TemplateTest {
    /**
     * Simple generator ref to object.
     */
    private SimpleGenerator simpleGenerator;
    /**
     * Ref to some map object.
     */
    private Map<String, String> map;

    /**
     * Method creates generator with HashMap and put some values in it.
     */
    @Before
    public void create() {
        simpleGenerator = new SimpleGenerator();
        map = new HashMap<>();
        map.put("${name}", "Evgeny");
        map.put("${subject}", "you");
        map.put("${sos}", "Aaa");
    }

    /**
     * Test of how SimpleGenerator works.
     *
     * @throws KeyException - throws error if we don't have such values in the map.
     */
    @Test
    public void whenReplaceKeysInLineThenWeGotLineWithReplacedWordTest() throws KeyException {
        String text = "I am ${name}, who are ${subject}?";
        String checked = "I am Evgeny, who are you?";
        String result = simpleGenerator.generate(text, map);
        assertThat(result, is(checked));
    }

    /**
     * Test of how SimpleGenerator works.
     *
     * @throws KeyException - throws error if we don't have such values in the map.
     */
    @Test
    public void whenReplaceThreePairOfKeysThenWeGotLineWithReplacedKeysTest() throws KeyException {
        String text = "Help, ${sos}, ${sos}, ${sos}!";
        String checked = "Help, Aaa, Aaa, Aaa!";
        String result = simpleGenerator.generate(text, map);
        assertThat(result, is(checked));
    }

    /**
     * Test of how SimpleGenerator works.
     *
     * @throws KeyException - throws error if we don't have such values in the map.
     */
    @Test(expected = KeyException.class)
    public void whenReplaceKeysThenGotErrorTest() throws KeyException{
        String text = "Help, ${key}";
        String checked = "Error";
        String result = simpleGenerator.generate(text, map);
        assertThat(result, is(checked));
    }

}