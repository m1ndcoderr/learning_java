package ru.evgenyhodz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Brand of a car.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
@Entity
@Table (name = "brands")
public class Brand {
    /**
     * Brand id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Brand name. Like "Skoda" or "BMW".
     */
    @Column(name = "name", nullable = false, unique = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        return id == brand.id && name.equals(brand.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}
