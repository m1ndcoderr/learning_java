package ru.evgenyhodz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.08.2017
 */
@Entity
@Table(name = "images")
public class Image {
    /**
     * Image id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Image url.
     */
    @Column(name = "url", nullable = false)
    private String url;

    /**
     * Default constructor.
     */
    public Image() {
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
     * Setter.
     *
     * @param imageId image.
     */
    public void setId(int imageId) {
        this.id = imageId;
    }

    /**
     * Url getter.
     *
     * @return url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter.
     *
     * @param imageUrl url.
     */
    public void setUrl(String imageUrl) {
        this.url = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (id == image.id) if (url.equals(image.url)) return true;
        return false;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + url.hashCode();
        return result;
    }
}
