package ru.evgenyhodz;

import java.util.Scanner;

/**
 * User's input from keyboard.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 28.12.2016
 */
public class UserInput {
    /**
     * Input of string only.
     *
     * @param scanner - reader from anywhere.
     * @return - key.
     */
    String input(Scanner scanner) {
        String result = null;
        if (scanner.hasNextLine()) {
            result = scanner.nextLine();
        } else {
            System.out.print("Error!\n");
        }
        return result;
    }

    /**
     * Method to enter numbers.
     *
     * @return double value.
     */
    public double inputOfNumber() {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        if (scanner.hasNextDouble()) {
            result = scanner.nextDouble();
        } else {
            System.out.println("That's not a number!");
        }
        return result;
    }
}
