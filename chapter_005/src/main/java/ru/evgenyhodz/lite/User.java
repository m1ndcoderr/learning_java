package ru.evgenyhodz.lite;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 17.03.2017
 */
public class User implements Comparable<User> {
    /**
     *
     */
    private Integer id;
    /**
     *
     */
    private int age;
    /**
     *
     */
    private String name, city;

    /**
     * Constructor.
     *
     * @param id   id
     * @param name name
     * @param city city
     */
    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Constructor.
     *
     * @param name name
     * @param age  age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Getter.
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Getter.
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Compares ages.
     *
     * @param user user
     * @return int
     */
    @Override
    public int compareTo(User user) {
//        return user.age >= age ? -1 : 0; not correct...
        return Integer.compare(age, user.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return city != null ? city.equals(user.city) : user.city == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
