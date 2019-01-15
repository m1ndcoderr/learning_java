package ru.evgenyhodz.GroceryStore;

import ru.evgenyhodz.Food.Food;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 24.12.2016
 */
public class Shop extends Storage {
    /**
     * Constructor.
     *
     * @param storage - array with objects.
     */
    public Shop(ArrayList<Object> storage) {
        super(storage);
    }

    /**
     * Method to show that is in the store.
     */
    @Override
    public void whatIsIn() {
        if (!getStorage().isEmpty()) {
            for (int i = 0; i < getStorage().size(); i++) {
                System.out.println(getStorage().get(i).getClass().getSimpleName() + " is in the Shop.");
            }
        } else {
            System.out.print("Shop is empty.\n");
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
        if (percentage < 75 && percentage > 25) {
            result = true;
            getStorage().add(food);
            System.out.print("Sending " + food.getName() + " to shop.\n");
        } else if (percentage <= 25 && percentage > 0) {
            result = true;
            int lowPrice = (Integer.valueOf(food.getPrice()) * Integer.valueOf(food.getDiscount()) / 100);
            food.setPrice(String.valueOf(lowPrice));
            getStorage().add(food);
            System.out.print("Sending " + food.getName() + " to shop with discount(-" + food.getDiscount() + "%).\n");
        }
        return result;
    }
}