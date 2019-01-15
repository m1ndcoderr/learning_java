package ru.evgenyhodz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Car drive, for example, "front".
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
@Entity
@Table(name = "wheeldrives")
public class WheelDrive {
    /**
     * Drive id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Drive type.
     */
    @Column(name = "type", nullable = false, unique = true)
    private String type;

    /**
     * Constructor default.
     */
    public WheelDrive() {
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
     * @param driveId id.
     */
    public void setId(int driveId) {
        this.id = driveId;
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
     * @param driveType type.
     */
    public void setType(String driveType) {
        this.type = driveType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WheelDrive that = (WheelDrive) o;

        return id == that.id && type.equals(that.type);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + type.hashCode();
        return result;
    }
}
