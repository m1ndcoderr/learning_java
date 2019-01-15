package ru.evgenyhodz.Dispatch;

import ru.evgenyhodz.ConversionFood.ConversionFood;
import ru.evgenyhodz.Food.Food;
import ru.evgenyhodz.GroceryStore.Storage;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.12.2016
 */
public class ExtendedControl extends ControlQuality {
    /**
     * @param food -
     */
    private void extControl(Food food) {
        storageList.stream().filter(aStorageList -> aStorageList.getClass().getSimpleName().equals("ColdPlace") ||
                aStorageList.getClass().getSimpleName().equals("Conversion")).forEach(aStorageList -> {
            aStorageList.checkProduct(food);
        });
    }

    /**
     * Realizing control of food quality.
     * Getting store from list and execute check-method.
     *
     * @param food - food to be sent.
     */
    @Override
    public void control(Food food) {
        if (!(food instanceof ConversionFood)) {
            storageList.stream().filter(storage -> !storage.getClass().getSimpleName().equals("ColdPlace") ||
                    !storage.getClass().getSimpleName().equals("Conversion")).forEach(storage -> {
                storage.checkProduct(food);
            });
        } else {
            extControl(food);
        }
    }
}
