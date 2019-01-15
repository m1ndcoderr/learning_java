package ru.evgenyhodz;

import ru.evgenyhodz.Dispatch.ControlQuality;
import ru.evgenyhodz.Food.*;
import ru.evgenyhodz.GroceryStore.Shop;
import ru.evgenyhodz.GroceryStore.Trash;
import ru.evgenyhodz.GroceryStore.Warehouse;

import java.util.ArrayList;

/**
 * Class to start the program.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.12.2016
 */
public class Start {
    /**
     * Start of the program.
     *
     * @param args - empty in this case.
     */
    public static void main(String[] args) {
        Food cheese = new Cheese("Cheese", "2016/10/25", "2016/10/29", "100", "50");
        Food milk = new Milk("Milk", "2017/01/01", "2017/01/02", "49", "10");
        Food eggs = new Eggs("Eggs", "2016/07/25", "2016/08/19", "63", "23");
        Food meat = new Meat("Meat", "2016/11/25", "2017/01/30", "370", "150");
        Food snickers = new Snickers("Snickers", "2016/11/20", "2017/06/15", "45", "15");
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.fill(new Warehouse(new ArrayList<>()));
        controlQuality.fill(new Shop(new ArrayList<>()));
        controlQuality.fill(new Trash(new ArrayList<>()));
        controlQuality.control(cheese);
        controlQuality.control(milk);
        controlQuality.control(eggs);
        controlQuality.control(meat);
        controlQuality.control(snickers);
        System.out.println("\nRESULTS:");
        controlQuality.show();
    }
}
