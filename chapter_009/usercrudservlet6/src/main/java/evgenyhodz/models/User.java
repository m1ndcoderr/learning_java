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
    private String name, login, email;
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
     */
    public User(String name, String login, String email, LocalDate createDate, Role role) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.role = role;
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
}
