package ru.evgenyhodz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 26.08.2017
 */
@Entity
@Table(name = "advertisements")
public class Advertisement {
    /**
     * Ad id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Ad creator.
     */
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
    /**
     * Ad car.
     */
    @ManyToOne
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;
    /**
     * Ad image.
     */
    @ManyToOne
    @JoinColumn(name = "id_image", nullable = false)
    private Image image;
    /**
     * Ad description.
     */
    @Column(name = "description")
    private String description;
    /**
     * Sold or not.
     */
    @Column(name = "sold")
    private boolean sold;
    /**
     * Car's price.
     */
    @Column(name = "price")
    private double price;
    /**
     * Ad create date.
     */
    @Column(name = "create_date")
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

    @Override
    public String toString() {
        return "Advertisement id: " + this.id + ", " + this.car.toString() + ", " + this.getDate().toString() + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advertisement that = (Advertisement) o;

        return id == that.id
                && sold == that.sold
                && Double.compare(that.price, price) == 0
                && user.equals(that.user)
                && car.equals(that.car)
                && image.equals(that.image)
                && description.equals(that.description)
                && date.equals(that.date);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + user.hashCode();
        result = 31 * result + car.hashCode();
        result = 31 * result + image.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (sold ? 1 : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + date.hashCode();
        return result;
    }
}
