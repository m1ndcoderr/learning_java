package carstore.models;

/**
 * Car's engine. For example: Skoda, 1.4 L I4 TSI, Petrol.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
public class Engine {
    /**
     * Engine id.
     */
    private int id;
    /**
     * Manufacturer.
     */
    private Brand brand;
    /**
     * Engine model.
     */
    private Model model;
    /**
     * Engine type.
     */
    private String type;
    /**
     * Engine's capacity.
     */
    private double capacity;

    /**
     * Constructor default.
     */
    public Engine() {
    }

    /**
     * Capacity getter.
     *
     * @return capacity.
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * Capacity setter.
     *
     * @param engineCapacity engine capacity.
     */
    public void setCapacity(double engineCapacity) {
        this.capacity = engineCapacity;
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
     * Engine id setter.
     *
     * @param engineId id.
     */
    public void setId(int engineId) {
        this.id = engineId;
    }

    /**
     * Brand getter.
     *
     * @return brand.
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Brand setter.
     *
     * @param engineBrand brand.
     */
    public void setBrand(Brand engineBrand) {
        this.brand = engineBrand;
    }

    /**
     * Model getter.
     *
     * @return model.
     */
    public Model getModel() {
        return model;
    }

    /**
     * Model setter.
     *
     * @param engineModel engine model.
     */
    public void setModel(Model engineModel) {
        this.model = engineModel;
    }

    /**
     * Type getter.
     *
     * @return type.
     */
    public String getType() {
        return type;
    }

    /**
     * Type setter.
     *
     * @param engineType type.
     */
    public void setType(String engineType) {
        this.type = engineType;
    }
}
