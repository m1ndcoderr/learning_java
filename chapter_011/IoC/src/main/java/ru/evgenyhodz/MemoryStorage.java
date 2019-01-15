package ru.evgenyhodz;

import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 17.08.2017
 */
public class MemoryStorage implements Storage {
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(MemoryStorage.class);
    /**
     * User storage.
     */
    private ArrayList<User> storage = new ArrayList<>();

    /**
     * Getter.
     *
     * @return ArrayList.
     */
    public ArrayList<User> getStorage() {
        return storage;
    }

    /**
     * Adds user to storage.
     *
     * @param user user.
     */
    @Override
    public void add(User user) {
        try {
            this.storage.add(user);
        } catch (Exception e) {
            LOGGER.error("MemoryStorage add user exception: " + e);
        }
    }
}
