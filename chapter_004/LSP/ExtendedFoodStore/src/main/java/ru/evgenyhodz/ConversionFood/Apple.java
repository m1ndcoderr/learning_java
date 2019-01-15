package ru.evgenyhodz.ConversionFood;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.12.2016
 */
public class Apple extends ConversionFood {
    /**
     * Constructor of some food kind.
     *
     * @param name         - name of product.
     * @param createDate   - date of creation.
     * @param expiryDate   - date of expiry.
     * @param price        - price.
     * @param discount     - discount.
     * @param canReproduct - flag.
     */
    public Apple(String name, String createDate, String expiryDate, String price, String discount, boolean canReproduct) {
        super(name, createDate, expiryDate, price, discount, canReproduct);
    }
}
