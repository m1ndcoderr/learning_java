package ru.evgenyhodz.Dispatch;

import ru.evgenyhodz.Food.Food;
import ru.evgenyhodz.GroceryStore.Storage;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 24.12.2016
 */
public class ControlQuality {
    /**
     * List of stores.
     */
    List<Storage> storageList = new LinkedList<>();

    /**
     * Realizing control of food quality.
     * Getting store from list and execute check-method.
     *
     * @param food - food to be sent.
     */
    public void control(Food food) {
        for (Storage storage : storageList) {
            storage.checkProduct(food);
        }
    }

    /**
     * To show what our stores contains inside.
     */
    public void show() {
        storageList.forEach(Storage::whatIsIn);
    }

    /**
     * Filling the list of storage with objects.
     */
    public void fill(Storage storage) {
        this.storageList.add(storage);
    }
}