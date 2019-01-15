package ru.evgenyhodz.start;

/**
 * Special class realize user's input. Created for tests commonly.
 */
public class StubInput implements Input {
    /**
     * Special storage of emulated answers.
     */
    private String[] answers;
    /**
     * Position in storage.
     */
    private int position = 0;

    /**
     * Constructor.
     *
     * @param answers - simulated answers of user in tests.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Method for tests.
     *
     * @param question - string value.
     * @return
     */
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * @param question - string value.
     * @param range    array with keys.
     * @return int value.
     */
    public int ask(String question, int[] range) {
        //throw new UnsupportedOperationException("Unsupported operation");
        return -1;
    }
}

