package carstore.models;

/**
 * Car transmission, for example: 7-speed automatic DSG.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
public class Transmission {
    /**
     * Transmission id.
     */
    private int id;
    /**
     * Transmission type.
     */
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
}
