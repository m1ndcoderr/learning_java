package ru.evgenyhodz;

import ru.evgenyhodz.Items.Addition;
import ru.evgenyhodz.Items.Calc;
import ru.evgenyhodz.Items.Item;
import ru.evgenyhodz.Items.Substraction;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 07.01.2017
 */
public class Begin {
    /**
     * User's input.
     */
    private final UserInput userInput;
    /**
     * Read data from keyboard.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructor.
     *
     * @param input - user's input.
     */
    private Begin(final UserInput input) {
        this.userInput = input;
    }


    /**
     * Method is creating menu for user.
     */
    private void init() {
        ItemsMenu iMenu = new ItemsMenu(userInput, new ArrayList<>());
        Item item = new Calc("1", "Section one. Simple Calculation + and -", new ArrayList<>());
        Item subAddition = new Addition("1.1", "Sub-Section one. Addition +", new ArrayList<>());
        Item subSubstraction = new Substraction("1.2", "Sub-Section two. Substraction -", new ArrayList<>());
        iMenu.fillMenu(item);
        item.add(subAddition);
        item.add(subSubstraction);
        do {
            System.out.println("Choose action: ");
            iMenu.show(iMenu.getList());
            String key = (userInput.input(scanner));
            iMenu.select(iMenu.getList(), key);
            System.out.println("Exit? y/n :");
        } while (!scanner.nextLine().equals("y"));
    }

    /**
     * Start of program.
     *
     * @param args - in this case is empty.
     */
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        new Begin(userInput).init();
    }
}