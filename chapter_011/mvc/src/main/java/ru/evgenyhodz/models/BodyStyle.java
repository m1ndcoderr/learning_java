package ru.evgenyhodz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Body of a car. For example, "Sedan".
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
@Entity
@Table(name = "bodystyles")
public class BodyStyle {
    /**
     * Body id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Body, for example, "Minivan".
     */
    @Column(name = "body", nullable = false, unique = true)
    private String body;

    /**
     * Constructor default.
     */
    public BodyStyle() {
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
     * Body setter.
     *
     * @param bodyId bodyId.
     */
    public void setId(int bodyId) {
        this.id = bodyId;
    }

    /**
     * Body getter.
     *
     * @return body type.
     */
    public String getBody() {
        return body;
    }

    /**
     * Body getter.
     *
     * @param carBody body.
     */
    public void setBody(String carBody) {
        this.body = carBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BodyStyle bodyStyle = (BodyStyle) o;

        return id == bodyStyle.id && body.equals(bodyStyle.body);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + body.hashCode();
        return result;
    }
}
