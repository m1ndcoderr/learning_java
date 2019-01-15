package carstore.models;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.08.2017
 */
public class Image {
    /**
     * Image id.
     */
    private int id;
    /**
     * Image url.
     */
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
}
