package ru.evgenyhodz;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 18.12.2016
 */
public class Settings {
    /**
     * Properties.
     */
    private final Properties properties = new Properties();

    /**
     * Getting values by key.
     *
     * @param key - string value.
     * @return - string value.
     */
    public String getValue(String key) {
        return this.properties.getProperty(key);
    }

    /**
     * Load data from stream.
     *
     * @param in - input stream.
     */
    public void load(InputStream in) {
        try {
            this.properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
