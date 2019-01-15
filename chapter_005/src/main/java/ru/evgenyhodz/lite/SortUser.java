package ru.evgenyhodz.lite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 17.03.2017
 */
public class SortUser {
    /**
     * Creates Set from List of Users.
     *
     * @param list - input List.
     * @return - Set Collection.
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>();
        for (User user : list) {
            result.add(user);
        }
        return result;
    }

    /**
     * Creates Set with a Users sorted by HashCode.
     *
     * @param list input list
     * @return Set collection
     */
    public List<User> sortHash(List<User> list) {
        List<User> result = new ArrayList<>();
        for (User user : list) {
            result.add(user);
        }
        Collections.sort(result, new ByHash());
        return result;
    }

    /**
     * Creates Set with a Users sorted by name length.
     *
     * @param list input list
     * @return Set collection
     */
    public List<User> sortLength(List<User> list) {
        List<User> result = new ArrayList<>();
        for (User user : list) {
            result.add(user);
        }
        Collections.sort(result, new ByLength());
        return result;
    }

    /**
     * Class with overrided comparator to sort by hash code.
     */
    private class ByHash implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.hashCode() - o2.hashCode();
        }
    }

    /**
     * Class with overrided comparator to sort by name length.
     */
    private class ByLength implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.getName().length() - o2.getName().length();
        }
    }
}
