package carstore.models;

/**
 * Brand of a car.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
public class Brand {
    /**
     * Brand id.
     */
    private int id;
    /**
     * Brand name. Like "Skoda" or "BMW".
     */
    private String name;

    /**
     * Constructor default.
     */
    public Brand() {
    }

    /**
     * Id getter.
     *
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Id setter.
     *
     * @param brandId id to set.
     */
    public void setId(int brandId) {
        this.id = brandId;
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
     * @param brandName name to set.
     */
    public void setName(String brandName) {
        this.name = brandName;
    }
}
