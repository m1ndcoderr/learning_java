package ru.evgenyhodz.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.evgenyhodz.models.Advertisement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 11.10.2017
 */
@Repository
public class AdvertisementDAOImpl implements AdvertisementDAO {

    /**
     * Log4j logger.
     */
    private static final Logger LOG = Logger.getLogger(AdvertisementDAOImpl.class);
    /**
     * Session factory.
     */
    private SessionFactory sessionFactory;

    /**
     * This thing for spring??
     *
     * @param sf .
     */
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    /**
     * Add new advertisement to database.
     *
     * @param object new advertisement to add.
     */
    @Override
    public void addAdvertisement(Advertisement object) {
        try (Session session = this.sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
            LOG.info("Advertisement saved successfully, advertisement details: " + object.toString());
        }
    }

    /**
     * Updates advertisement in database.
     *
     * @param object advertisement to change.
     */
    @Override
    public void updateAdvertisement(Advertisement object) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
            LOG.info("Advertisement " + object.getId() + " updated successfully.");
        }
    }

    /**
     * Removes advertisement by id.
     *
     * @param id - id of advertisement ot remove.
     */
    @Override
    public void deleteAdvertisement(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(session.get(Advertisement.class, id));
            session.getTransaction().commit();
            LOG.info("Advertisement with id " + id + " deleted.");
        }
    }

    /**
     * Receives advertisement by id from DB.
     *
     * @param id - id of searching advertisement.
     * @return some advertisement.
     */
    @Override
    public Advertisement findById(int id) {
        Advertisement result;
        try (Session session = sessionFactory.openSession()) {
            result = (Advertisement) session.get(Advertisement.class, id);
            LOG.info("Advertisement with id: " + result.getId() + " found.");
        }
        return result;
    }

    /**
     * Receives advertisement by description.
     *
     * @param description advertisement's description.
     * @return Advertisement object.
     */
    @SuppressWarnings("unchecked")
    @Override
    public Advertisement findByDesc(String description) {
        Advertisement result;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Advertisement where description=:description");
            query.setParameter("description", description);
            result = (Advertisement) query.uniqueResult();
            LOG.info("Advertisement with desc: \"" + result.getDescription() + "\" found.");
        }
        return result;
    }

    /**
     * Receives all advertisements from database.
     *
     * @return list of advertisements.
     */
    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Advertisement> getAllAds() {
        ArrayList<Advertisement> result = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List list = session.createQuery("from Advertisement").list();
            session.getTransaction().commit();
            if (!list.isEmpty()) {
                result = new ArrayList<>();
                for (Object adv : list) {
                    result.add((Advertisement) adv);
                }
            }
        }
        return result;
    }
}
