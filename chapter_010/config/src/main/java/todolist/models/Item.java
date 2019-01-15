package todolist.models;

import java.sql.Timestamp;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 19.08.2017
 */
public class Item {
    /**
     * To avoid magin number checkstyle error.
     */
    private static final int THIRTYONE = 31;
    /**
     * Item's id.
     */
    private int id;
    /**
     * Item's description.
     */
    private String desc;
    /**
     * Item's create date.
     */
    private Timestamp created;
    /**
     * Item's boolean done or not done task.
     */
    private boolean done;

    /**
     * Getter.
     *
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter.
     *
     * @param itemId id.
     */
    public void setId(int itemId) {
        this.id = itemId;
    }

    /**
     * Getter.
     *
     * @return description.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter.
     *
     * @param itemDesc description.
     */
    public void setDesc(String itemDesc) {
        this.desc = itemDesc;
    }

    /**
     * Getter.
     *
     * @return create date.
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * Setter.
     *
     * @param itemCreated set's create date.
     */
    public void setCreated(Timestamp itemCreated) {
        this.created = itemCreated;
    }

    /**
     * Getter.
     *
     * @return boolean.
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Setter.
     *
     * @param itemDone boolean.
     */
    public void setDone(boolean itemDone) {
        this.done = itemDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        return id == item.id && done == item.done && desc != null && desc.equals(item.desc)
                || desc == null && item.desc == null && (created != null
                && created.equals(item.created) || created == null && item.created == null);

    }

    @Override
    public int hashCode() {
        int result = id;
        if (desc != null) {
            result = THIRTYONE * result + desc.hashCode();
        } else {
            result = THIRTYONE * result;
        }
        if (created != null) {
            result = THIRTYONE * result + created.hashCode();
        } else {
            result = THIRTYONE * result;
        }
        if (done) {
            result = THIRTYONE * result + 1;
        } else {
            result = THIRTYONE * result;
        }
        return result;
    }
}
