package ru.evgenyhodz;

import ru.evgenyhodz.Items.Item;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 07.01.2017
 */
public class ItemsMenu {
    /**
     * Ref to user's input.
     */
    private UserInput input;
    /**
     * List of our items.
     */
    private ArrayList<Item> list;

    /**
     * Constructor.
     *
     * @param input - user's input.
     * @param list - list with items.
     */
    public ItemsMenu(UserInput input, ArrayList<Item> list) {
        this.input = input;
        this.list = list;
    }

    /**
     * Getter.
     *
     * @return - array list.
     */
    public ArrayList<Item> getList() {
        return list;
    }

    /**
     * Add items to menu.
     *
     * @param item - item.
     */
    public void fillMenu(Item item) {
        this.list.add(item);
    }

    /**
     * Method to show all user's actions.
     */
    public void show(ArrayList<Item> list) {
        for (Item item : list) {
            System.out.println(item.info());
            if (!item.getItemList().isEmpty()) {
                show(item.getItemList());
            }
        }
    }


    /**
     * Method to choose action.
     *
     * @param key  - special key of action.
     * @param list - list with items.
     * @return - true/false.
     */
    public boolean select(ArrayList<Item> list, String key) {
        boolean valid = false;
        for (Item item : list) {
            if (key.equals(item.key())) {
                item.execute();
                valid = true;
            }
            if (!item.getItemList().isEmpty()) {
                select(item.getItemList(), key);
            }
        }
        return valid;
    }
}

