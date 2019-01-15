package ru.evgenyhodz;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 22.12.2016
 */
public interface Action {
    /**
     * Special method that return key - number.
     *
     * @return key.
     */
    int key();

    /**
     * Method realizing user's action.
     */
    void execute();
}
