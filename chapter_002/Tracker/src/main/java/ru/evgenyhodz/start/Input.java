package ru.evgenyhodz.start;

/**
 * Interface for user's input.
 */
public interface Input {
    /**
     * Ask user a question.
     *
     * @param question - string value.
     * @return - string value.
     */
    String ask(String question);

    /**
     * Ask user smth and return key.
     *
     * @param question - string value.
     * @param range    array with keys.
     * @return int value.
     */
    int ask(String question, int[] range);
}
