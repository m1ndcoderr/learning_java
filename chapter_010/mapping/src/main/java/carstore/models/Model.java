package carstore.models;

/**
 * Model of a car.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
public class Model {
    /**
     * Id of model.
     */
    private int id;
    /**
     * Car brand. For example, "Skoda".
     */
    private Brand brand;
    /**
     * Car model. For example, "Rapid".
     */
    private String model;

    /**
     * Constructor default.
     */
    public Model() {
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
     * Model setter.
     *
     * @param modelId model.
     */
    public void setId(int modelId) {
        this.id = modelId;
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
     * @param carBrand car brand.
     */
    public void setBrand(Brand carBrand) {
        this.brand = carBrand;
    }

    /**
     * Model getter.
     *
     * @return model.
     */
    public String getModel() {
        return model;
    }

    /**
     * Model setter.
     *
     * @param carModel car model.
     */
    public void setModel(String carModel) {
        this.model = carModel;
    }
}
