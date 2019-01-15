package ru.evgenyhodz.start;

/**
 * Interface to describe user's actions which will be realized in inner classes.
 */
public interface UserAction {
    /**
     * Special method that return key - number.
     *
     * @return key.
     */
    int key();

    /**
     * Execution of some user's action.
     *
     * @param input   - user's input.
     * @param tracker - class with actions to manage applications.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Shows some sort of info about action.
     *
     * @return string value.
     */
    String info();

}
