package ru.evgenyhodz.Conversion;

import ru.evgenyhodz.ConversionFood.ConversionFood;
import ru.evgenyhodz.GroceryStore.Storage;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 13.01.2017
 */
public abstract class StorageDecorator extends Storage {
    /**
     * Constructor.
     *
     * @param storage - array with objects.
     */
    public StorageDecorator(ArrayList<Object> storage) {
        super(storage);
    }

    public abstract boolean checkProduct(ConversionFood food);
}