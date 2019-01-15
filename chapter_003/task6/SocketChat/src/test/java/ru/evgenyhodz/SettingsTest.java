package ru.evgenyhodz;

import org.junit.Test;

import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 18.12.2016
 */
public class SettingsTest {
    /**
     * Test verifies the data download from app.properties
     *
     * @throws Exception - exceptions.
     */
    @Test
    public void whenClassLoaderTest() throws Exception {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream is = loader.getResourceAsStream("app.properties")) {
            settings.load(is);
        }
        String firstValue = settings.getValue("port");
        String secondValue = settings.getValue("ip");
        assertThat(firstValue, is("5555"));
        assertThat(secondValue, is("127.0.0.1"));
    }
}