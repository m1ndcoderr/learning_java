package ru.evgenyhodz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.08.2017
 */
@Entity
@Table(name = "users")
public class User {
    /**
     * User's id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * User's name.
     */
    @Column(name = "name", nullable = false)
    private String name;
    /**
     * User's password.
     */
    @Column(name = "password", nullable = false)
    private String password;
    /**
     * User's email.
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    /**
     * User's phone.
     */
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    /**
     * User's social url.
     */
    @Column(name = "url", nullable = false, unique = true)
    private String socialUrl;

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Getter.
     *
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter.
     *
     * @param userId image.
     */
    public void setId(int userId) {
        this.id = userId;
    }

    /**
     * Name getter.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Name setter.
     *
     * @param userName name to set.
     */
    public void setName(String userName) {
        this.name = userName;
    }

    /**
     * Password getter.
     *
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Password setter.
     *
     * @param userPass to set.
     */
    public void setPassword(String userPass) {
        this.password = userPass;
    }

    /**
     * Email getter.
     *
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Email setter.
     *
     * @param userEmail email.
     */
    public void setEmail(String userEmail) {
        this.email = userEmail;
    }

    /**
     * Phone getter.
     *
     * @return phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Phone setter.
     *
     * @param userPhone phone.
     */
    public void setPhone(String userPhone) {
        this.phone = userPhone;
    }

    /**
     * Getter of link to user's social page.
     *
     * @return link.
     */
    public String getSocialUrl() {
        return socialUrl;
    }

    /**
     * Setter.
     *
     * @param userSocialUrl url to social page.
     */
    public void setSocialUrl(String userSocialUrl) {
        this.socialUrl = userSocialUrl;
    }

    /**
     * Gets info about user in a string.
     *
     * @return String info.
     */
    @Override
    public String toString() {
        return "User id=" + id + ", name=" + name + ", password=" + password
                + ", email=" + email + ", phone=" + phone + ", social url=" + socialUrl + ";\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id && name.equals(user.name) && password.equals(user.password)
                && email.equals(user.email) && phone.equals(user.phone) && socialUrl.equals(user.socialUrl);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + socialUrl.hashCode();
        return result;
    }
}
