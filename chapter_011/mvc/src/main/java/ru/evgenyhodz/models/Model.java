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
 * Model of a car.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
@Entity
@Table(name = "models")
public class Model {
    /**
     * Id of model.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Car brand. For example, "Skoda".
     */
    @ManyToOne
    @JoinColumn(name = "id_brand", nullable = false)
    private Brand brand;
    /**
     * Car model. For example, "Rapid".
     */
    @Column(name = "model", nullable = false, unique = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model1 = (Model) o;

        return id == model1.id && brand.equals(model1.brand) && model.equals(model1.model);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + brand.hashCode();
        result = 31 * result + model.hashCode();
        return result;
    }
}
