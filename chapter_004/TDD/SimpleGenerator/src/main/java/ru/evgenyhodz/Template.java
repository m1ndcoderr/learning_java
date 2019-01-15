package ru.evgenyhodz;

import java.security.KeyException;
import java.util.Map;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 08.01.2017
 */
public interface Template {
    /**
     * Getting string value with some keys and then return values by that keys.
     *
     * @param template - string with keys.
     * @param map      - special values.
     * @return - some values.
     */
    String generate(String template, Map<String, String> map) throws KeyException;
}
