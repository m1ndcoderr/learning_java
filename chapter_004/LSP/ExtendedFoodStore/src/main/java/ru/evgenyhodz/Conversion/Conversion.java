package ru.evgenyhodz.Conversion;

import ru.evgenyhodz.ConversionFood.ConversionFood;
import ru.evgenyhodz.Food.Food;
import ru.evgenyhodz.GroceryStore.Storage;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 27.12.2016
 */
public class Conversion extends StorageDecorator {
    /**
     * Constructor.
     *
     * @param storage - array with objects.
     */
    public Conversion(ArrayList<Object> storage) {
        super(storage);
    }

    /**
     * Method to show that is in the store.
     */
    @Override
    public void whatIsIn() {
        if (!getStorage().isEmpty()) {
            for (int i = 0; i < getStorage().size(); i++) {
                System.out.println(getStorage().get(i).getClass().getSimpleName() + " is in the Conversion.");
            }
        } else {
            System.out.print("Conversion is empty.\n");
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
        if (food instanceof ConversionFood) {
            checkProduct((ConversionFood) food);
            result = true;
        }
        return result;
    }

    /**
     * Special method to check conversional food.
     *
     * @param food - some product.
     */
    @Override
    public boolean checkProduct(ConversionFood food) {
        boolean result = false;
        double percentage = find.numOfDays(food.getCreateDate(), food.getExpiryDate());
        if (percentage == 0 && food.isCanReproduct()) {
            getStorage().add(food);
            result = true;
            System.out.print("Sending " + food.getName() + " to conversion...\n");
        }
        return result;
    }
}