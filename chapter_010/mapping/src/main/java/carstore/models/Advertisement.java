package carstore.models;

import java.sql.Timestamp;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.08.2017
 */
public class Advertisement {
    /**
     * Ad id.
     */
    private int id;
    /**
     * Ad creator.
     */
    private User user;
    /**
     * Ad car.
     */
    private Car car;
    /**
     * Ad image.
     */
    private Image image;
    /**
     * Ad description.
     */
    private String description;
    /**
     * Sold or not.
     */
    private boolean sold;
    /**
     * Car's price.
     */
    private double price;
    /**
     * Ad create date.
     */
    private Timestamp date;

    /**
     * Constructor default.
     */
    public Advertisement() {
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
     * @param adId id to set.
     */
    public void setId(int adId) {
        this.id = adId;
    }

    /**
     * User getter.
     *
     * @return user.
     */
    public User getUser() {
        return user;
    }

    /**
     * User setter.
     *
     * @param adUser user to set.
     */
    public void setUser(User adUser) {
        this.user = adUser;
    }

    /**
     * Car getter.
     *
     * @return car.
     */
    public Car getCar() {
        return car;
    }

    /**
     * Car setter.
     *
     * @param adCar car to set.
     */
    public void setCar(Car adCar) {
        this.car = adCar;
    }

    /**
     * Image getter.
     *
     * @return image.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Image setter.
     *
     * @param adImage image to set.
     */
    public void setImage(Image adImage) {
        this.image = adImage;
    }

    /**
     * Description getter.
     *
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Description setter.
     *
     * @param adDesc description to set.
     */
    public void setDescription(String adDesc) {
        this.description = adDesc;
    }

    /**
     * Sold getter.
     *
     * @return boolean.
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * Sold setter.
     *
     * @param adSold boolean.
     */
    public void setSold(boolean adSold) {
        this.sold = adSold;
    }

    /**
     * Price getter.
     *
     * @return price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Price setter.
     *
     * @param adPrice to set.
     */
    public void setPrice(double adPrice) {
        this.price = adPrice;
    }

    /**
     * Create date getter.
     *
     * @return Timestamp.
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Create date setter.
     *
     * @param adDate Timestamp to set.
     */
    public void setDate(Timestamp adDate) {
        this.date = adDate;
    }
}
