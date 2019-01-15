package ru.evgenyhodz.start;

import java.util.Scanner;

/**
 * Class that realize user's input.
 */
public class ConsoleInput implements Input {
    /**
     * Scanner object which read data from keyboard.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method ask user a question and return user's answer.
     *
     * @param question - question to user.
     * @return - user's answer.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.next();
    }

    /**
     * Method ask user a smth and return key.
     *
     * @param question - question.
     * @param range    - array with keys.
     * @return - int value.
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
