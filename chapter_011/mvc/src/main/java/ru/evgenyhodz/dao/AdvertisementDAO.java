package ru.evgenyhodz.dao;

import ru.evgenyhodz.models.Advertisement;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 11.10.2017
 */
public interface AdvertisementDAO {
    /**
     * Add new advertisement to database.
     *
     * @param object new advertisement to add.
     */
    public void addAdvertisement(Advertisement object);

    /**
     * Updates advertisement in database.
     *
     * @param object advertisement to change.
     */
    public void updateAdvertisement(Advertisement object);

    /**
     * Removes advertisement by id.
     *
     * @param id - id of advertisement ot remove.
     */
    public void deleteAdvertisement(int id);

    /**
     * Receives advertisement by id from DB.
     *
     * @param id - id of searching advertisement.
     * @return some advertisement.
     */
    public Advertisement findById(int id);

    /**
     * Receives advertisement by description.
     *
     * @param description advertisement's description.
     * @return Advertisement object.
     */
    public Advertisement findByDesc(String description);

    /**
     * Receives all advertisements from database.
     *
     * @return list of advertisements.
     */
    public ArrayList<Advertisement> getAllAds();
}
