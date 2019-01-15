package ru.evgenyhodz.models;

/**
 * Class describing user's application.
 * An application can have the following fields:
 * name, description, commentaries and date of creation.
 * Also it has a unique id, which is assigned
 * after you create an application.
 *
 * @author Evgeny Khodzitskiy.
 */
public class Application {
    /**
     * Application has name, description, comment and creationDate fields.
     */
    public String name, description, comment, creationDate;
    /**
     * Unique number of application.
     */
    private String id;

    /**
     * Constructor of application.
     *
     * @param name         - name of application.
     * @param description  - description of application.
     * @param creationDate - date of creation.
     */
    public Application(String name, String description, String creationDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
    }

    /**
     * Another constructor with comment.
     *
     * @param name         - name of application.
     * @param description  - description of application.
     * @param creationDate - date of creation.
     * @param comment      - commentary which user can write to application.
     */
    public Application(String name, String description, String comment, String creationDate) {
        this(name, description, creationDate);
        this.comment = comment;

    }

    /**
     * Also constructor with unique id.
     *
     * @param id           - unique number of application.
     * @param name         - name of application.
     * @param description  - description of application.
     * @param creationDate - date of creation.
     * @param comment      - commentary which user can write to application.
     */
    public Application(String id, String name, String description, String comment, String creationDate) {
        this(name, description, comment, creationDate);
        this.id = id;
    }

    /**
     * Date getter.
     *
     * @return - string value - date.
     */
    public String getCreationDate() {
        return this.creationDate;
    }

    /**
     * Name getter.
     *
     * @return - string value - application's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Description's getter.
     *
     * @return - string value - description of application.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter.
     *
     * @return - string value - commentary.
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * Id's getter.
     *
     * @return - unique number in string.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set the value of id.
     *
     * @param id - id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set commentary.
     *
     * @param comment - commentary.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Set name.
     *
     * @param name - name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set date of creation.
     *
     * @param creationDate - string value.
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

}
