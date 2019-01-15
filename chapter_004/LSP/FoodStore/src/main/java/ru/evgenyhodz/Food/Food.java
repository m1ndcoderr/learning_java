package ru.evgenyhodz.Food;

/**
 * Class to describe food.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 24.12.2016
 */
public abstract class Food {
    /**
     * Fields that food have.
     */
    private String name, createDate, expiryDate, price, discount;

    /**
     * Constructor of some food kind.
     *
     * @param name       - name of product.
     * @param createDate - date of creation.
     * @param expiryDate - date of expiry.
     * @param price      - price.
     * @param discount   - discount.
     */
    protected Food(String name, String createDate, String expiryDate, String price, String discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
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
     * Getter.
     *
     * @return - expiry date.
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Getter.
     *
     * @return - date of creation.
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * Getter.
     *
     * @return discount.
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Getter.
     *
     * @return price.
     */
    public String getPrice() {
        return price;
    }

    /**
     * Setter.
     *
     * @param name - name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter.
     *
     * @param price - price to set.
     */
    public void setPrice(String price) {
        this.price = price;
    }

}
