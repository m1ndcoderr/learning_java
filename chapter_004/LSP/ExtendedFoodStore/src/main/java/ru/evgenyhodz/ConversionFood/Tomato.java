package ru.evgenyhodz.ConversionFood;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 27.12.2016
 */
public class Tomato extends ConversionFood {
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
    public Tomato(String name, String createDate, String expiryDate, String price, String discount, boolean canReproduct) {
        super(name, createDate, expiryDate, price, discount, canReproduct);
    }
}
