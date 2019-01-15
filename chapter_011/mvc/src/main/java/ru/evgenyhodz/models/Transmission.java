package ru.evgenyhodz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Car transmission, for example: 7-speed automatic DSG.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
@Entity
@Table(name = "transmissions")
public class Transmission {
    /**
     * Transmission id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Transmission type.
     */
    @Column(name = "type", nullable = false, unique = true)
    private String type;

    /**
     * Constructor default.
     */
    public Transmission() {
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
     * Transmission setter.
     *
     * @param transmissionId id.
     */
    public void setId(int transmissionId) {
        this.id = transmissionId;
    }

    /**
     * Transmission type getter.
     *
     * @return type.
     */
    public String getType() {
        return type;
    }

    /**
     * Transmission setter.
     *
     * @param transmissionType type.
     */
    public void setType(String transmissionType) {
        this.type = transmissionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transmission that = (Transmission) o;

        return id == that.id && type.equals(that.type);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type.hashCode();
        return result;
    }
}
