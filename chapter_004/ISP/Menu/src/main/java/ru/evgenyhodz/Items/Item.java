package ru.evgenyhodz.Items;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 07.01.2017
 */
public abstract class Item {
    /**
     * Name of item.
     */
    private String name;
    /**
     * Key of item.
     */
    private String key;
    /**
     * Could contain items.
     */
    private ArrayList<Item> itemList;

    /**
     * Constructor.
     *
     * @param key      - key of item.
     * @param name     - name of item.
     * @param itemList - storage of items.
     */
    Item(String key, String name, ArrayList<Item> itemList) {
        this.key = key;
        this.name = name;
        this.itemList = itemList;
    }

    /**
     * Method to add item to the storage.
     *
     * @param item - item.
     */
    public void add(Item item) {
        this.itemList.add(item);
    }

    /**
     * Get the list of items.
     *
     * @return - items list.
     */
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    /**
     * Special method that return key - number.
     *
     * @return key.
     */
    public String key() {
        return key;
    }

    /**
     * Shows some sort of info about item.
     *
     * @return string value.
     */
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }

    /**
     * Any action.
     */
    public abstract void execute();
}
