package ru.evgenyhodz.start;

/**
 * Class to demonstrate the work of abstract Java class.
 */
public abstract class BaseAction implements UserAction {
    /**
     * Name of action.
     */
    private String name;

    /**
     * Constructor.
     *
     * @param name - name of action.
     */
    public BaseAction(String name) {
        this.name = name;
    }

    /**
     * Method to show some info.
     *
     * @return - string value.
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
