package ru.evgenyhodz.store;

/**
 * Interface store<T extends Base>.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 28.01.2017
 */
interface Store<T extends Base> {
    /**
     * Adds new value to store.
     *
     * @param value - value to add.
     */
    void add(T value);

    /**
     * Gets value from store by id.
     *
     * @param id - id.
     * @return - some id value.
     */
    T get(String id);

    /**
     * Updates value in store by id.
     *
     * @param id    - id.
     * @param value - value set update.
     */
    void update(String id, T value);

    /**
     * Deleting id from store.
     *
     * @param id - id to delete.
     */
    void delete(String id);
}
