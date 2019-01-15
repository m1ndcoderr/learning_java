package ru.evgenyhodz.store;

/**
 * Abstract class Base.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @version 1.0
 * @since 27.01.2017
 */
abstract class Base {

    /**
     * Id.
     */
    private String id;

    /**
     * Getter.
     *
     * @return id.
     */
    String getId() {
        return this.id;
    }

    /**
     * Setter.
     *
     * @param value - set this instead of id.
     */
    void setId(String value) {
        this.id = value;
    }

}
