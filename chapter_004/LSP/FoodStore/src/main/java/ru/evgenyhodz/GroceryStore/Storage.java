package ru.evgenyhodz.GroceryStore;

import ru.evgenyhodz.Dispatch.ControlQuality;
import ru.evgenyhodz.Dispatch.DaysFounder;
import ru.evgenyhodz.Food.Food;

import java.util.ArrayList;

/**
 * Abstract class describing any storage.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.12.2016
 */
public abstract class Storage {
    /**
     * new Control object.
     */
    private ControlQuality controlQuality = new ControlQuality();
    /**
     * Object to find days.
     */
    protected DaysFounder find = new DaysFounder();
    /**
     * Storage with products.
     */
    private ArrayList<Object> storage;

    /**
     * Getter of storage.
     *
     * @return - storage of products.
     */
    public ArrayList<Object> getStorage() {
        return storage;
    }

    /**
     * Constructor.
     *
     * @param storage - array with objects.
     */
    public Storage(ArrayList<Object> storage) {
        this.storage = storage;
    }

    /**
     * Method to show that is in the store.
     */
    public abstract void whatIsIn();

    /**
     * Method to add products to store.
     *
     * @param food - some kind of product.
     */
    public abstract boolean checkProduct(Food food);

    /**
     * Retrieve all the products and redistribute them again.
     */
    void getExpaired(ArrayList<Object> storage) {
        for (int i = 0; i < storage.size(); i++) {
            if (!storage.isEmpty()) {
                Food food = (Food) storage.get(i);
                double quality = find.numOfDays(food.getCreateDate(), food.getExpiryDate());
                if (quality != 0) {
                    controlQuality.control(food);
                } else {
                    storage.remove(i);
                }
            }
        }
    }
}

