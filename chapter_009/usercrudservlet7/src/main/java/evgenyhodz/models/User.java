package evgenyhodz.models;

import java.time.LocalDate;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 03.06.2017
 */
public class User {
    /**
     * User's name, login and email.
     */
    private String name, login, email, country, city;
    /**
     * User's create date.
     */
    private LocalDate createDate;
    /**
     * User's role.
     */
    private Role role;

    /**
     * Constructor.
     *
     * @param name       - username.
     * @param login      - user's login.
     * @param email      - user's email.
     * @param createDate - user's create date.
     * @param role       - user's role.
     * @param country    - user's country.
     * @param city       - user's city.
     */
    public User(String name, String login, String email, String country, String city, LocalDate createDate, Role role) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.role = role;
        this.country = country;
        this.city = city;
    }

    /**
     * Getter.
     *
     * @return Role of User.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Getter.
     *
     * @return user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter.
     *
     * @return user's login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Getter.
     *
     * @return user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter.
     *
     * @return user's create date.
     */
    public LocalDate getCreateDate() {
        return createDate;
    }

    /**
     * Getter.
     *
     * @return country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Getter.
     *
     * @return city.
     */
    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return name != null ? name.equals(user.name) : user.name == null
                && (login != null ? login.equals(user.login) : user.login == null
                && (email != null ? email.equals(user.email) : user.email == null
                && (country != null ? country.equals(user.country) : user.country == null
                && (city != null ? city.equals(user.city) : user.city == null
                && (createDate != null ? createDate.equals(user.createDate) : user.createDate == null
                && (role != null ? role.equals(user.role) : user.role == null))))));

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
