package carstore.models;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.08.2017
 */
public class User {
    /**
     * User's id.
     */
    private int id;
    /**
     * Personal data.
     */
    private String name, password, email, phone, socialUrl;

    /**
     * Constructor default.
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
}
