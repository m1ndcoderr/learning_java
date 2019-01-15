package ru.evgenyhodz;

import java.security.KeyException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 31.12.2016
 */
public class SimpleGenerator implements Template {
    /**
     * Pattern to search keys in the string.
     */
    private final Pattern pattern = Pattern.compile("\\$\\{\\w*?\\}");

    /**
     * Getting string value with some keys and then return values by that keys.
     *
     * @param template - string with keys.
     * @param map      - special values.
     * @return - some values.
     */
    @Override
    public String generate(String template, Map<String, String> map) throws KeyException {
        String result = template;
        Matcher matcher = this.pattern.matcher(result);
        while (matcher.find()) {
            String value = map.get(matcher.group());
            if (value == null) {
                throw new KeyException("Key not found!");
            } else {
                result = matcher.replaceFirst(value);
                matcher.reset(result);
            }
        }
        return result;
    }
}
