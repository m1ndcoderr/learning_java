package ru.evgenyhodz;

import java.util.Objects;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 17.08.2017
 */
public class User {

    /**
     * Username.
     */
    private String name;

    /**
     * Constructor.
     *
     * @param name  - username.
     */

    public User(String name) {
        this.name = name;
    }

    /**
     * Getter.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter.
     *
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name.equals(user.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
