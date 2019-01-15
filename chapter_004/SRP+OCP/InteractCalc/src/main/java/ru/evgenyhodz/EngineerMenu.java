package ru.evgenyhodz;

import evgenyhodz.Calculate;

import java.util.Scanner;

/**
 * Expanded menu, some trigonometric operations added.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 23.12.2016
 */
public class EngineerMenu extends MenuCalc {
    /**
     * Reference to object with trigonometric functions.
     */
    private TrigFunctions trigFunctions;

    /**
     * Constructor of Extended menu.
     *
     * @param calculate     - ref to calculate class.
     * @param userInput     - ref to user's input.
     * @param trigFunctions - ref to trigonometric functions.
     * @param scanner - scanner to do number input.
     * @param text - scanner to do string input.
     */
    public EngineerMenu(Calculate calculate,
                        UserInput userInput,
                        TrigFunctions trigFunctions,
                        Scanner scanner,
                        Scanner text) {
        super(calculate, userInput, scanner, text);
        this.trigFunctions = trigFunctions;
    }

    /**
     * Some info how to use program.
     */
    @Override
    public void info() {
        System.out.print("______InteractCalc______\n" +
                "Possible Actions: \n" +
                "0 - addition;\n" +
                "1 - multiplication;\n" +
                "2 - division;\n" +
                "3 - submission;\n" +
                "4 - find sinus;\n" +
                "5 - find cosine;\n" +
                "6 - find tangent.\n");
    }

    /**
     * Filling storage with actions.
     */
    @Override
    public void fill() {
        this.actions[position++] = new Addition();
        this.actions[position++] = new Multiplication();
        this.actions[position++] = new Division();
        this.actions[position++] = new Submission();
        this.actions[position++] = new Sinus();
        this.actions[position++] = new Cosine();
        this.actions[position++] = new Tangent();
    }

    /**
     * Inner class to realize calculate operation "sinus".
     */
    private class Sinus implements Action {
        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 4;
        }

        /**
         * Method realizing user's action.
         */
        @Override
        public void execute() {
            if (userInput.ask("Would u like to use previous result of calculations? y/n\n", text).equals("y")) {
                trigFunctions.sinus(calculate.getResult());
            } else {
                System.out.print("Please, type variable.\n");
                trigFunctions.sinus(userInput.input(scanner));
            }
            System.out.print(calculate.getResult());
        }
    }

    /**
     * Inner class to realize calculate operation "cosine".
     */
    private class Cosine implements Action {

        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 5;
        }

        /**
         * Method realizing user's action.
         */
        @Override
        public void execute() {
            if (userInput.ask("Would u like to use previous result of calculations? y/n\n", text).equals("y")) {
                trigFunctions.cosine(calculate.getResult());
            } else {
                System.out.print("Please, type variable.\n");
                trigFunctions.cosine(userInput.input(scanner));
            }
            System.out.print(calculate.getResult());
        }
    }

    /**
     * Inner class to realize calculate operation "tangent".
     */
    private class Tangent implements Action {

        /**
         * Special method that return key - number.
         *
         * @return key.
         */
        @Override
        public int key() {
            return 6;
        }

        /**
         * Method realizing user's action.
         */
        @Override
        public void execute() {
            if (userInput.ask("Would u like to use previous result of calculations? y/n\n", text).equals("y")) {
                trigFunctions.tangent(calculate.getResult());
            } else {
                System.out.print("Please, type variable.\n");
                trigFunctions.tangent(userInput.input(scanner));
            }
            System.out.print(calculate.getResult());
        }
    }
}
