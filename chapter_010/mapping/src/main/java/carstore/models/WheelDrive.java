package carstore.models;

/**
 * Car drive, for example, "front".
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.08.2017
 */
public class WheelDrive {
    /**
     * Drive id.
     */
    private int id;
    /**
     * Drive type.
     */
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
}
