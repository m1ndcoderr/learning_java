package ru.evgenyhodz.ms;

import java.util.TreeMap;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 22.03.2017
 */
public class UserStorage {
    /**
     * Main storage.
     */
    private TreeMap<String, User> userStorage = new TreeMap<>();

    /**
     * Getter.
     *
     * @return storage
     */
    public synchronized TreeMap<String, User> getUserStorage() {
        return userStorage;
    }

    /**
     * Adding user to storage.
     *
     * @param user to add.
     */
    public synchronized void add(User user) {
        if (user.getUsername() != null) {
            userStorage.put(user.getUsername(), user);
        } else {
            System.out.println("Please, enter user name.");
        }
    }

    /**
     * Reading the amount of user .
     *
     * @param name name.
     * @return - amount.
     */
    public synchronized Integer read(String name) {
        if (userStorage.containsKey(name)) {
            return userStorage.get(name).getAmount();
        } else {
            System.out.println("No such name in database.");
            return null;
        }
    }

    /**
     * Changes amount of user
     *
     * @param name   name
     * @param number number
     */
    public synchronized boolean edit(String name, int number) {
        boolean result;
        if (userStorage.containsKey(name)) {
            userStorage.get(name).setAmount(number);
            result = true;
        } else {
            System.out.println("There is no such user.");
            result = false;
        }
        return result;
    }

    /**
     * Deleting user by name.
     *
     * @param name name.
     */
    public synchronized boolean delete(String name) {
        boolean result;
        if (userStorage.containsKey(name)) {
            userStorage.remove(name);
            result = true;
        } else {
            result = false;
            System.out.println("There is no such user.");
        }
        return result;
    }

    public synchronized boolean transfer(String nameFrom, String nameTo, int amount) {
        boolean result = false;
        if (userStorage.containsKey(nameFrom) && userStorage.containsKey(nameTo) && amount > 0) {
            // Step 1:
            userStorage.get(nameTo).setAmount(userStorage.get(nameFrom).getAmount() +
                    userStorage.get(nameTo).getAmount());
            // Step 2:
            userStorage.get(nameFrom).setAmount(userStorage.get(nameFrom).getAmount() - amount);

            result = true;
        }
        return result;
    }
}
