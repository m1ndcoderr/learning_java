package usersdatabase.models;

import java.time.LocalDate;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 03.06.2017
 */
public class User {
    /**
     * Var to avoid magic number mistake.
     */
    private static final int THIRTYONE = 31;
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
     * @param userName       - username.
     * @param userLogin      - user's login.
     * @param userEmail      - user's email.
     * @param userCreateDate - user's create date.
     * @param userRole       - user's role.
     * @param userCountry    - user's country.
     * @param userCity       - user's city.
     */
    public User(String userName, String userLogin, String userEmail,
                String userCountry, String userCity, LocalDate userCreateDate, Role userRole) {
        this.name = userName;
        this.login = userLogin;
        this.email = userEmail;
        this.createDate = userCreateDate;
        this.role = userRole;
        this.country = userCountry;
        this.city = userCity;
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

        return name != null && name.equals(user.name) || name == null && user.name == null
                && (login != null && login.equals(user.login) || login == null && user.login == null
                && (email != null && email.equals(user.email) || email == null && user.email == null
                && (country != null && country.equals(user.country) || country == null && user.country == null
                && (city != null && city.equals(user.city) || city == null && user.city == null
                && (createDate != null && createDate.equals(user.createDate) || createDate == null && user.createDate == null
                && (role != null && role.equals(user.role) || role == null && user.role == null))))));

    }

    @Override
    public int hashCode() {
        int result;
        if (name != null) {
            result = name.hashCode();
        } else {
            result = 0;
        }
        if (login != null) {
            result = THIRTYONE * result + login.hashCode();
        } else {
            result = THIRTYONE * result;
        }
        if (email != null) {
            result = THIRTYONE * result + email.hashCode();
        } else {
            result = THIRTYONE * result;
        }
        if (country != null) {
            result = THIRTYONE * result + country.hashCode();
        } else {
            result = THIRTYONE * result;
        }
        if (city != null) {
            result = THIRTYONE * result + city.hashCode();
        } else {
            result = THIRTYONE * result;
        }
        if (createDate != null) {
            result = THIRTYONE * result + createDate.hashCode();
        } else {
            result = THIRTYONE * result;
        }
        if (role != null) {
            result = THIRTYONE * result + role.hashCode();
        } else {
            result = THIRTYONE * result;
        }
        return result;
    }
}
