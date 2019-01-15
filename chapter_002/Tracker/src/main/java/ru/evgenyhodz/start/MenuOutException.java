package ru.evgenyhodz.start;

/**
 * Class to show some error message.
 */
public class MenuOutException extends RuntimeException {
    /**
     * Method to show some error message.
     *
     * @param msg - message.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
