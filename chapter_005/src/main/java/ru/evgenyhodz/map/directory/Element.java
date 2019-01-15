package ru.evgenyhodz.map.directory;

/**
 * @param <A> - represents key of map.
 * @param <B> - represents value of map.
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 24.02.2017
 */
public interface Element<A, B> {
    /**
     * Returns key.
     *
     * @return key.
     */
    A getKey();

    /**
     * Returns value.
     *
     * @return value.
     */
    B getValue();
}
