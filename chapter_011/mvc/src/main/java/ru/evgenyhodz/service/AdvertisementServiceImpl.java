package ru.evgenyhodz.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evgenyhodz.dao.AdvertisementDAO;
import ru.evgenyhodz.models.Advertisement;

import java.util.ArrayList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 12.10.2017
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementDAO advertisementDAO;

    public void setAdvertisementDAO(AdvertisementDAO advertisementDAO) {
        this.advertisementDAO = advertisementDAO;
    }

    /**
     * Add new advertisement to database.
     *
     * @param object new advertisement to add.
     */
    @Override
    @Transactional
    public void addAdvertisement(Advertisement object) {
        this.advertisementDAO.addAdvertisement(object);
    }

    /**
     * Updates advertisement in database.
     *
     * @param object advertisement to change.
     */
    @Override
    @Transactional
    public void updateAdvertisement(Advertisement object) {
        this.advertisementDAO.updateAdvertisement(object);
    }

    /**
     * Removes advertisement by id.
     *
     * @param id - id of advertisement ot remove.
     */
    @Override
    @Transactional
    public void deleteAdvertisement(int id) {
        this.advertisementDAO.deleteAdvertisement(id);
    }

    /**
     * Receives advertisement by id from DB.
     *
     * @param id - id of searching advertisement.
     * @return some advertisement.
     */
    @Override
    @Transactional
    public Advertisement findById(int id) {
        return this.advertisementDAO.findById(id);
    }

    /**
     * Receives advertisement by description.
     *
     * @param description advertisement's description.
     * @return Advertisement object.
     */
    @Override
    @Transactional
    public Advertisement findByDesc(String description) {
        return this.advertisementDAO.findByDesc(description);
    }

    /**
     * Receives all advertisements from database.
     *
     * @return list of advertisements.
     */
    @Override
    @Transactional
    public ArrayList<Advertisement> getAllAds() {
        return this.advertisementDAO.getAllAds();
    }
}
