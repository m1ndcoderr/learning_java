package ru.evgenyhodz.store;

import ru.evgenyhodz.SimpleArray;

import java.util.NoSuchElementException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 15.02.2017
 */
abstract class StoreBase<T extends Base> implements Store<T> {

    /**
     * Size of store.
     */
    private int arraySize = 10;
    /**
     * store with Users.
     */
    private SimpleArray<T> simpleArray = new SimpleArray<>(arraySize);


    /**
     * Adds new value to store.
     *
     * @param value - value to add.
     */
    @Override
    public void add(T value) {
        this.simpleArray.add(value);
    }

    /**
     * Gets value from store by id.
     *
     * @param id - id.
     * @return - some id value.
     */
    @Override
    public T get(String id) {
        T result = null;
        for (int y = 0; y < arraySize; y++) {
            if (simpleArray.get(y) != null && simpleArray.get(y).getId().equals(id)) {
                result = simpleArray.get(y);
                if (result != null) {
                    break;
                }
            } else {
                throw new NoSuchElementException("There is no such User.");
            }
        }
        return result;
    }

    /**
     * Updates value in store by id.
     *
     * @param id    - id.
     * @param value - value set update.
     */
    @Override
    public void update(String id, T value) {
        for (int i = 0; i < arraySize; i++) {
            if (simpleArray.get(i).getId().equals(id) && simpleArray.get(i) != null) {
                this.simpleArray.update(i, value);
                break;
            }
        }
    }

    /**
     * Deleting id from store.
     *
     * @param id - id to delete.
     */
    @Override
    public void delete(String id) {
        for (int i = 0; i < arraySize; i++) {
            if (simpleArray.get(i).getId().equals(id)
                    && simpleArray.get(i) != null) {
                this.simpleArray.delete(Integer.parseInt(simpleArray.get(i).getId()));
                break;
            }
        }
    }
}
