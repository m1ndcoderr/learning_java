package ru.evgenyhodz;

import java.util.Date;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 23.05.2017
 */
public class Advertisement {
    /**
     * Title of ad.
     */
    private String title;
    /**
     * Description of ad.
     */
    private String description;

    /**
     * Date of creation.
     */
    private Date date;

    /**
     * Constructor.
     *
     * @param title       title.
     * @param description desc.
     * @param date        create date.
     */
    public Advertisement(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    /**
     * Getter.
     *
     * @return title of ad.
     */
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }
}
