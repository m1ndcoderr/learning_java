package ru.evgenyhodz.map.directory;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.02.2017
 */
public interface ElementContainer<T, V> extends Iterable<Element<T, V>> {
    /**
     * Adding an item to container.
     *
     * @param key   - key.
     * @param value - value.
     * @return true/false.
     */
    boolean insert(T key, V value);

    /**
     * Getting an item from container.
     *
     * @param key - key.
     * @return - element.
     */
    V get(T key);

    /**
     * Deleting an item from container.
     *
     * @param key - key.
     * @return - true/false.
     */
    boolean delete(T key);
}
