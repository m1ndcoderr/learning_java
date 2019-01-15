package ru.evgenyhodz.GroceryStore;

import ru.evgenyhodz.Food.Food;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 24.12.2016
 */
public class Warehouse extends Storage {
    /**
     * Constructor.
     *
     * @param storage - array with objects.
     */
    public Warehouse(ArrayList<Object> storage) {
        super(storage);
    }

    /**
     * Method to show that is in the store.
     */
    @Override
    public void whatIsIn() {
        if (!getStorage().isEmpty()) {
            for (int i = 0; i < getStorage().size(); i++) {
                System.out.println(getStorage().get(i).getClass().getSimpleName() + " is in the Warehouse.");
            }
        } else {
            System.out.print("Warehouse is empty.\n");
        }
    }

    /**
     * Method to add products to store.
     *
     * @param food - some kind of product.
     */
    @Override
    public boolean checkProduct(Food food) {
        boolean result = false;
        double percentage = find.numOfDays(food.getCreateDate(), food.getExpiryDate());
        if (percentage >= 75) {
            result = true;
            getStorage().add(food);
            System.out.print("Sending " + food.getName() + " to warehouse.\n");
        }
        return result;
    }
}