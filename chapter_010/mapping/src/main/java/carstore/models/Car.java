package carstore.models;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
public class Car {
    /**
     * Car's id.
     */
    private int id;
    /**
     * Car's brand.
     */
    private Brand brand;
    /**
     * Car's model.
     */
    private Model model;
    /**
     * Car's body.
     */
    private BodyStyle bodyStyle;
    /**
     * Car's engine.
     */
    private Engine engine;
    /**
     * Car's transmission.
     */
    private Transmission transmission;
    /**
     * Car's drive (front, back, full).
     */
    private WheelDrive wheelDrive;
    /**
     * Horse powers, year of production, mileage.
     */
    private int horsePowers, productionYear, mileage;
    /**
     * Car's color.
     */
    private String color;

    /**
     * Constructor default.
     */
    public Car() {
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
     * @param carId to set.
     */
    public void setId(int carId) {
        this.id = carId;
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
     * @param carBrand to set.
     */
    public void setBrand(Brand carBrand) {
        this.brand = carBrand;
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
     * @param carModel to set.
     */
    public void setModel(Model carModel) {
        this.model = carModel;
    }

    /**
     * Body getter.
     *
     * @return body.
     */
    public BodyStyle getBodyStyle() {
        return bodyStyle;
    }

    /**
     * Body setter.
     *
     * @param carBody to set.
     */
    public void setBodyStyle(BodyStyle carBody) {
        this.bodyStyle = carBody;
    }

    /**
     * Engine getter.
     *
     * @return engine.
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Engine setter.
     *
     * @param carEngine engine.
     */
    public void setEngine(Engine carEngine) {
        this.engine = carEngine;
    }

    /**
     * Transmission getter.
     *
     * @return transmission.
     */
    public Transmission getTransmission() {
        return transmission;
    }

    /**
     * Transmission setter.
     *
     * @param carTransmission to set.
     */
    public void setTransmission(Transmission carTransmission) {
        this.transmission = carTransmission;
    }

    /**
     * Drive getter.
     *
     * @return wheel drive.
     */
    public WheelDrive getWheelDrive() {
        return wheelDrive;
    }

    /**
     * Wheel drive setter.
     *
     * @param carWheelDrive to set.
     */
    public void setWheelDrive(WheelDrive carWheelDrive) {
        this.wheelDrive = carWheelDrive;
    }

    /**
     * Number of horse powers.
     *
     * @return int value.
     */
    public int getHorsePowers() {
        return horsePowers;
    }

    /**
     * Set number of horse powers.
     *
     * @param carHorsePowers horse powers.
     */
    public void setHorsePowers(int carHorsePowers) {
        this.horsePowers = carHorsePowers;
    }

    /**
     * Getter.
     *
     * @return year of production.
     */
    public int getProductionYear() {
        return productionYear;
    }

    /**
     * Year setter.
     *
     * @param carProductionYear to set.
     */
    public void setProductionYear(int carProductionYear) {
        this.productionYear = carProductionYear;
    }

    /**
     * Getter.
     *
     * @return number of mileage.
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Mileage setter.
     *
     * @param carMileage to set.
     */
    public void setMileage(int carMileage) {
        this.mileage = carMileage;
    }

    /**
     * Getter.
     *
     * @return color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter.
     *
     * @param carColor color.
     */
    public void setColor(String carColor) {
        this.color = carColor;
    }
}
