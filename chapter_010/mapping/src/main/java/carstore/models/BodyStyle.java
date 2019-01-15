package carstore.models;

/**
 * Body of a car. For example, "Sedan".
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
public class BodyStyle {
    /**
     * Body id.
     */
    private int id;
    /**
     * Body, for example, "Minivan".
     */
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
}
