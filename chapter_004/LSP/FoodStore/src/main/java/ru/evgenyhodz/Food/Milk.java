package ru.evgenyhodz.Food;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 24.12.2016
 */
public class Milk extends Food{
    /**
     * Constructor of some food kind.
     *
     * @param name       - name of product.
     * @param createDate - date of creation.
     * @param expiryDate - date of expiry.
     * @param price      - price.
     * @param discount   - discount.
     */
    public Milk(String name, String createDate, String expiryDate, String price, String discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
