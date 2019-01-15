package ru.evgenyhodz;

import evgenyhodz.Calculate;

import java.util.Scanner;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 22.12.2016
 */
public class InteractCalc {
    /**
     * User's input.
     */
    private final UserInput input;
    /**
     * Object to do some simple calculations.
     */
    private final MenuCalc menu;

    /**
     * Constructor of start class includes UserInput and MenuCalc.
     *
     * @param input - user's input.
     * @param menu  - menu filled with actions.
     */
    private InteractCalc(final UserInput input, final MenuCalc menu) {
        this.input = input;
        this.menu = menu;
    }

    /**
     * This method creates menu with actions.
     * @param scanner - read numbers.
     * @param text - read strings.
     */
    private void init(Scanner scanner, Scanner text) {
        menu.fill();
        menu.info();
        do {
            System.out.print("Choose action:\n");
            double key = input.input(scanner);
            menu.select(key);
        } while (!input.ask("\nExit? y/n\n", text).equals("y"));
    }

    /**
     * Start of program.
     *
     * @param args - empty array in this case.
     */
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        TrigFunctions trigFunctions = new TrigFunctions(calculate);
        Scanner scanner = new Scanner(System.in);
        Scanner text = new Scanner(System.in);
        UserInput userInput = new UserInput();
        MenuCalc menuCalc = new EngineerMenu(calculate, userInput, trigFunctions, scanner, text);
        new InteractCalc(userInput, menuCalc).init(scanner, text);
    }
}
