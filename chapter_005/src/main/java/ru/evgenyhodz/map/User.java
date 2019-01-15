package ru.evgenyhodz.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 24.02.2017
 */
public class User {
    /**
     * Name.
     */
    private String name;
    /**
     * Count (?) of children.
     */
    private int children;
    /**
     * Day of birth.
     */
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args){

        User first = new User("Bob", 1, new GregorianCalendar(2015, 0, 31));
        User second = new User("Bob", 1, new GregorianCalendar(2015, 0, 31));

        Map<User, Object> map = new HashMap<>();
        map.put(first, new Object());
        map.put(second, new Object());

        System.out.println(map);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
