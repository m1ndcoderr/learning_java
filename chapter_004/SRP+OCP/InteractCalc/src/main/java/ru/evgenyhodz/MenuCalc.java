package ru.evgenyhodz;

import evgenyhodz.Calculate;

import java.util.Scanner;

/**
 * Filling menu with user's actions.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 22.12.2016
 */
public class MenuCalc {
    /**
     * Class Calculate from chapter_001. Includes 4 methods.
     */
    protected Calculate calculate;
    /**
     * Ref to reader of numbers.
     */
    protected Scanner scanner;
    /**
     * Ref to reader of string values.
     */
    protected Scanner text;

    /**
     * Calculate operations.
     *
     * @param calculate - simple calculate actions.
     * @param userInput - user's input.
     * @param scanner   - reader of numbers from keyboard.
     * @param text      - reader of string values.
     */
    public MenuCalc(Calculate calculate, UserInput userInput, Scanner scanner, Scanner text) {
        this.calculate = calculate;
        this.userInput = userInput;
        this.scanner = scanner;
        this.text = text;
    }

    /**
     * Usual user input.
     */
    protected UserInput userInput;
    /**
     * Our storage with actions.
     */
    protected Action[] actions = new Action[7];
    /**
     * Position in the storage.
     */
    protected int position = 0;

    /**
     * Filling storage with actions.
     */
    public void fill() {
        this.actions[position++] = new Addition();
        this.actions[position++] = new Multiplication();
        this.actions[position++] = new Division();
        this.actions[position++] = new Submission();
    }

    /**
     * Some info how to use program.
     */
    public void info() {
        System.out.print("______InteractCalc______\n" +
                "Possible Actions: \n" +
                "0 - addition;\n" +
                "1 - multiplication;\n" +
                "2 - division;\n" +
                "3 - submission.\n");
    }

    /**
     * Method to select action from storage by key.
     *
     * @param key - number of action.
     */
    public void select(double key) {
        try {
            this.actions[(int) key].execute();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("There is no such action.");
        }
    }

    /**
     * Inner class to realize calculate operation "addition".
     */
    protected class Addition implements Action {
        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 0;
        }

        /**
         * Method realizing user's action.
         */
        @Override
        public void execute() {
            if (userInput.ask("Would u like to use previous result of calculations? y/n\n", text).equals("y")) {
                calculate.add(calculate.getResult(), userInput.input(scanner));
            } else {
                System.out.print("Please, type first and second variable.\n");
                calculate.add(userInput.input(scanner), userInput.input(scanner));
            }
            System.out.print(calculate.getResult());
        }
    }

    /**
     * Inner class to realize calculate operation "multiplication".
     */
    protected class Multiplication implements Action {
        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 1;
        }

        /**
         * Method realizing user's action.
         */
        @Override
        public void execute() {
            if (userInput.ask("Would u like to use previous result of calculations? y/n\n", text).equals("y")) {
                calculate.mul(calculate.getResult(), userInput.input(scanner));
            } else {
                System.out.print("Please, type first and second variable.\n");
                calculate.mul(userInput.input(scanner), userInput.input(scanner));
            }
            System.out.print(calculate.getResult());
        }
    }

    /**
     * Inner class to realize calculate operation "division".
     */
    protected class Division implements Action {
        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 2;
        }

        /**
         * Method realizing user's action.
         */
        @Override
        public void execute() {
            if (userInput.ask("Would u like to use previous result of calculations? y/n\n", text).equals("y")) {
                calculate.div(calculate.getResult(), userInput.input(scanner));
            } else {
                System.out.print("Please, type first and second variable.\n");
                calculate.div(userInput.input(scanner), userInput.input(scanner));
            }
            System.out.print(calculate.getResult());
        }
    }

    /**
     * Inner class to realize calculate operation "submission".
     */
    protected class Submission implements Action {
        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 3;
        }

        /**
         * Method realizing user's action.
         */
        @Override
        public void execute() {
            if (userInput.ask("Would u like to use previous result of calculations? y/n\n", text).equals("y")) {
                calculate.sub(calculate.getResult(), userInput.input(scanner));
            } else {
                System.out.print("Please, type first and second variable.\n");
                calculate.sub(userInput.input(scanner), userInput.input(scanner));
            }
            System.out.print(calculate.getResult());
        }
    }
}
