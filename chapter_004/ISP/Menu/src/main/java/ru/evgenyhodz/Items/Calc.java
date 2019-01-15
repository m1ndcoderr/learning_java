package ru.evgenyhodz.Items;

import ru.evgenyhodz.Interfaces.Info;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 15.01.2017
 */
public class Calc extends Item implements Info {

    /**
     * Constructor.
     *
     * @param key      - key of item.
     * @param name     - name of item.
     * @param itemList - storage of items.
     */
    public Calc(String key, String name, ArrayList<Item> itemList) {
        super(key, name, itemList);
    }

    /**
     * Any action.
     */
    @Override
    public void execute() {
        help();
    }

    /**
     * To tell to user about something.
     */
    @Override
    public void help() {
        System.out.print("This section is responsible for the addition and subtraction.\n" +
                "User should enter two numbers to do action.\n");
    }
}
