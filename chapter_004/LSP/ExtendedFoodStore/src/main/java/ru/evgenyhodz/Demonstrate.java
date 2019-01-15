package ru.evgenyhodz;

import ru.evgenyhodz.Conversion.ColdPlace;
import ru.evgenyhodz.Conversion.Conversion;
import ru.evgenyhodz.ConversionFood.Apple;
import ru.evgenyhodz.ConversionFood.ConversionFood;
import ru.evgenyhodz.ConversionFood.Tomato;
import ru.evgenyhodz.Dispatch.ControlQuality;
import ru.evgenyhodz.Food.Food;
import ru.evgenyhodz.Food.Milk;
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
public class Demonstrate {
    /**
     * Start of the program.
     *
     * @param args - empty in this case.
     */
    public static void main(String[] args) {
        Food milk = new Milk("Milk", "2016/11/03", "2017/01/02", "49", "10");
        ConversionFood apple = new Apple("Apple", "2016/11/20", "2016/11/21", "45", "15", true);
        ConversionFood tomato = new Tomato("Tomato", "2016/11/20", "2017/11/21", "45", "15", true);
        ControlQuality extendedControl = new ControlQuality();
        extendedControl.fill(new Warehouse(new ArrayList<>()));
        extendedControl.fill(new Shop(new ArrayList<>()));
        extendedControl.fill(new Trash(new ArrayList<>()));
        extendedControl.fill(new Conversion(new ArrayList<>()));
        extendedControl.fill(new ColdPlace(new ArrayList<>()));
        extendedControl.control(apple);
        extendedControl.control(tomato);
        extendedControl.control(milk);
        extendedControl.show();
    }
}
