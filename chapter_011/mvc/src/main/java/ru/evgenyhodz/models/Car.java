package ru.evgenyhodz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
@Entity
@Table(name = "cars")
public class Car {
    /**
     * Car's id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Car's brand.
     */
    @ManyToOne
    @JoinColumn(name = "id_brand", nullable = false)
    private Brand brand;
    /**
     * Car's model.
     */
    @ManyToOne
    @JoinColumn(name = "id_model", nullable = false)
    private Model model;
    /**
     * Car's body.
     */
    @ManyToOne
    @JoinColumn(name = "id_bodystyle", nullable = false)
    private BodyStyle bodyStyle;
    /**
     * Car's engine.
     */
    @ManyToOne
    @JoinColumn(name = "id_engine", nullable = false)
    private Engine engine;
    /**
     * Car's transmission.
     */
    @ManyToOne
    @JoinColumn(name = "id_transmission", nullable = false)
    private Transmission transmission;
    /**
     * Car's drive (front, back, full).
     */
    @ManyToOne
    @JoinColumn(name = "id_wheeldrive", nullable = false)
    private WheelDrive wheelDrive;
    /**
     * Horse powers.
     */
    @Column(name = "horsepowers")
    private int horsePowers;
    /**
     * Year of production.
     */
    @Column(name = "productionYear")
    private int productionYear;
    /**
     * Mileage.
     */
    @Column(name = "mileage")
    private int mileage;
    /**
     * Car's color.
     */
    @Column(name = "color", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id == car.id
                && horsePowers == car.horsePowers
                && productionYear == car.productionYear
                && mileage == car.mileage
                && brand.equals(car.brand)
                && model.equals(car.model)
                && bodyStyle.equals(car.bodyStyle)
                && engine.equals(car.engine)
                && transmission.equals(car.transmission)
                && wheelDrive.equals(car.wheelDrive)
                && color.equals(car.color);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + bodyStyle.hashCode();
        result = 31 * result + engine.hashCode();
        result = 31 * result + transmission.hashCode();
        result = 31 * result + wheelDrive.hashCode();
        result = 31 * result + horsePowers;
        result = 31 * result + productionYear;
        result = 31 * result + mileage;
        result = 31 * result + color.hashCode();
        return result;
    }
}
