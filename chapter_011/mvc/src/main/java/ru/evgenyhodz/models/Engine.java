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
 * Car's engine. For example: Skoda, 1.4 L I4 TSI, Petrol.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
@Entity
@Table(name = "engines")
public class Engine {
    /**
     * Engine id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Manufacturer.
     */
    @ManyToOne
    @JoinColumn(name = "id_brand", nullable = false)
    private Brand brand;
    /**
     * Engine model.
     */
    @ManyToOne
    @JoinColumn(name = "id_model", nullable = false)
    private Model model;
    /**
     * Engine type.
     */
    @Column(name = "type", nullable = false)
    private String type;
    /**
     * Engine's capacity.
     */
    @Column(name = "capacity", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        return id == engine.id && Double.compare(engine.capacity, capacity) == 0
                && brand.equals(engine.brand) && model.equals(engine.model) && type.equals(engine.type);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + type.hashCode();
        temp = Double.doubleToLongBits(capacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
