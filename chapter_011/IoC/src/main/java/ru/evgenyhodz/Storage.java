package ru.evgenyhodz;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 17.08.2017
 */
public interface Storage {
    /**
     * Adds user to storage.
     *
     * @param user user.
     */
    void add(User user);
}
