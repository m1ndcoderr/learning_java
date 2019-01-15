package ru.evgenyhodz.Items;

import evgenyhodz.Calculate;
import ru.evgenyhodz.Interfaces.NumbersInput;
import ru.evgenyhodz.UserInput;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 15.01.2017
 */
public class Substraction extends Item implements NumbersInput {
    /**
     * Constructor.
     *
     * @param key      - key of item.
     * @param name     - name of item.
     * @param itemList - storage of items.
     */
    public Substraction(String key, String name, ArrayList<Item> itemList) {
        super(key, name, itemList);
    }

    /**
     * Method to enter numbers.
     *
     * @return double value.
     */
    @Override
    public double numEnter() {
        return new UserInput().inputOfNumber();
    }

    /**
     * Any action.
     */
    @Override
    public void execute() {
        System.out.println("Please, enter two numbers!");
        Calculate calculate = new Calculate();
        calculate.sub(numEnter(), numEnter());
        System.out.println(calculate.getResult());
    }
}
