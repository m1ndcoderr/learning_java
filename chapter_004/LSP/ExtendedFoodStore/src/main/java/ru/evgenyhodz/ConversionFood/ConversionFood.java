package ru.evgenyhodz.ConversionFood;

import ru.evgenyhodz.Food.Food;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.12.2016
 */
public abstract class ConversionFood extends Food {
    /**
     * To mark product.
     */
    private boolean canReproduct;

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
    protected ConversionFood(String name,
                             String createDate,
                             String expiryDate,
                             String price,
                             String discount,
                             boolean canReproduct) {
        super(name, createDate, expiryDate, price, discount);
        this.canReproduct = canReproduct;
    }

    /**
     * Getter.
     *
     * @return true/false.
     */
    public boolean isCanReproduct() {
        return canReproduct;
    }
}
