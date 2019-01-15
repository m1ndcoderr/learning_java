package ru.evgenyhodz.ms;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 23.03.2017
 */
public class User {
    /**
     * User's name.
     */
    private String username;
    /**
     * Amount of money.
     */
    private int amount;

    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Constructor.
     *
     * @param name   name
     * @param amount amount
     */
    public User(String name, int amount) {
        this.username = name;
        this.amount = amount;
    }

    /**
     * Getter.
     * @return username.
     */
    public synchronized String getUsername() {
        return username;
    }

    /**
     * Getter.
     *
     * @return amount.
     */
    public synchronized int getAmount() {
        return amount;
    }

    /**
     * Setter.
     *
     * @param amount - amount.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Setter.
     * @param name for change.
     */
    public void setUsername(String name){
        this.username = name;
    }
}
