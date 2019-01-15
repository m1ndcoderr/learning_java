package evgenyhodz.models;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 07.07.2017
 */
public class Role {
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
     * @param id       role id.
     * @param name role name.
     */
    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter.
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter.
     * @return role name.
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != role.id) return false;
        return name != null ? name.equals(role.name) : role.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
