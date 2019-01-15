package usersdatabase.models;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 07.07.2017
 */
public class Role {
    /**
     * To avoid magic number mistake.
     */
    private static final int THIRTYONE = 31;
    /**
     * Role id.
     */
    private int id;
    /**
     * Role name.
     */
    private String name;

    /**
     * Constructor.
     *
     * @param roleId   role id.
     * @param roleName role name.
     */
    public Role(int roleId, String roleName) {
        this.id = roleId;
        this.name = roleName;
    }

    /**
     * Getter.
     *
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter.
     *
     * @return role name.
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return id == role.id && (name != null && name.equals(role.name)
                || name == null && role.name == null);

    }

    @Override
    public int hashCode() {
        int result = id;
        if (name != null) {
            result = THIRTYONE * result + name.hashCode();
        } else {
            result = THIRTYONE * result;
        }
        return result;
    }
}
