package ru.evgenyhodz.GroceryStore;

import org.junit.Test;
import ru.evgenyhodz.Dispatch.DaysFounder;
import ru.evgenyhodz.Food.Eggs;
import ru.evgenyhodz.Food.Food;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 12.01.2017
 */
public class StorageTest {
    /**
     * If we have expiry product in the storage then we will delete it.
     */
    @Test
    public void whenExpiryInsideThenDeleteTheExpiryProductTest() {
        Warehouse storage = new Warehouse(new ArrayList<>());
        Food eggs = new Eggs("Eggs", "2016/07/25", "2016/08/19", "63", "23");
        storage.getStorage().add(eggs);
        storage.getExpaired(storage.getStorage());
        assertThat(storage.getStorage().isEmpty(), is(true));
    }

    /**
     * If we have expiry product in the storage then we will delete it.
     * If the product is fresh, then it will be resorted to storage again.
     */
    @Test
    public void whenNotExpiryInsideThenResortTheProductToStorageAgainTest() {
        Storage storage = new Shop(new ArrayList<>());
        Food eggs = new Eggs("Eggs", "2017/01/04", "2017/02/14", "63", "23");
        storage.getStorage().add(eggs);
        storage.getExpaired(storage.getStorage());
        assertThat(!storage.getStorage().isEmpty(), is(true));
    }
}