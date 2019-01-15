package ru.evgenyhodz;

import java.util.Scanner;

/**
 * User's input from keyboard.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 22.12.2016
 */
public class UserInput {
    /**
     * Input of numbers only.
     *
     * @param scanner - reader from anywhere.
     * @return - number.
     */
    public double input(Scanner scanner) {
        double result = 0;
        if (scanner.hasNextDouble()) {
            result = scanner.nextDouble();
        } else {
            System.out.print("Please, type numbers!\n");
        }
        return result;
    }

    /**
     * Method ask user a question and return user's answer.
     *
     * @param scanner  - reader from anywhere.
     * @param question - program question.
     * @return - user's answer.
     */
    public String ask(String question, Scanner scanner) {
        System.out.print(question);
        String result = null;
        if (scanner.hasNextLine()) {
            result = scanner.nextLine();
        }
        return result;
    }
}
