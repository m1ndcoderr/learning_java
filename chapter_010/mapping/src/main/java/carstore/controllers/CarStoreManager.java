package carstore.controllers;

import carstore.models.Advertisement;
import carstore.models.BodyStyle;
import carstore.models.Brand;
import carstore.models.Car;
import carstore.models.Engine;
import carstore.models.Image;
import carstore.models.Model;
import carstore.models.Transmission;
import carstore.models.User;
import carstore.models.WheelDrive;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 29.08.2017
 */
public class CarStoreManager {
    /**
     * This class.
     */
    private static final CarStoreManager CAR_STORE_MANAGER = new CarStoreManager();
    /**
     * Session factory.
     */
    private final SessionFactory sessionFactory = HibernateUtil.setUp();

    /**
     * Getter.
     *
     * @return this class.
     */
    public static CarStoreManager getCONTROLLER() {
        return CAR_STORE_MANAGER;
    }

    /**
     * Receives advertisement by id from DB.
     *
     * @param id - id of searching advertisement.
     * @return some advertisement.
     */
    public Advertisement findById(int id) {
        Advertisement result;
        try (Session session = sessionFactory.openSession()) {
            result = (Advertisement) session.get(Advertisement.class, id);
        }
        return result;
    }

    /**
     * Receives advertisement by description.
     *
     * @param description advertisement's description.
     * @return Advertisement object.
     */
    public Advertisement findByDesc(String description) {
        Advertisement result;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Advertisement where description=:description");
            query.setParameter("description", description);
            result = (Advertisement) query.uniqueResult();
        }
        return result;
    }

    /**
     * Finds brand by name.
     *
     * @param name name.
     * @return Brand.
     */
    public Brand findBrandByName(String name) {
        Brand result;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Brand where name=:name");
            query.setParameter("name", name);
            result = (Brand) query.uniqueResult();
        }
        return result;
    }

    /**
     * Finds model by name.
     *
     * @param model string value.
     * @return Model.
     */
    public Model findModelByName(String model) {
        Model result;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Model where model=:model");
            query.setParameter("model", model);
            result = (Model) query.uniqueResult();
        }
        return result;
    }

    /**
     * Finds body by name.
     *
     * @param body body.
     * @return BodyStyle.
     */
    public BodyStyle findBodyByName(String body) {
        BodyStyle result;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from BodyStyle where body=:body");
            query.setParameter("body", body);
            result = (BodyStyle) query.uniqueResult();
        }
        return result;
    }

    /**
     * Finds engine's capasity from string.
     *
     * @param str string.
     * @return double.
     */
    private double getDoubleFromString(String str) {
        String[] s = str.split(" ");
        Pattern p = Pattern.compile("(\\d)+\\.(\\d)+");
        double d = 0;
        for (String value : s) {
            Matcher m = p.matcher(value);
            if (m.find())
                d = Double.parseDouble(m.group());
        }
        return d;
    }

    /**
     * Finds engine by data in a string.
     *
     * @param string what maybe contains capacity and engine type.
     * @return Engine.
     */
    public Engine findEngineByNameAndCapacity(String string) {
        Engine result = null;

        double capacity = getDoubleFromString(string);
        String type = null;
        if (string.contains("diesel")) {
            type = "diesel";
        }
        if (string.contains("petrol")) {
            type = "petrol";
        }
        if (string.contains("hybrid")) {
            type = "hybrid";
        }
        for (Engine engine : getEngines()) {
            if (engine.getCapacity() == capacity && engine.getType().equals(type)) {
                result = engine;
            }
        }
        return result;
    }

    /**
     * Finds transmission by name.
     *
     * @param type type
     * @return Transmission.
     */
    public Transmission findTransmissionByName(String type) {
        Transmission result;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Transmission where type=:type");
            query.setParameter("type", type);
            result = (Transmission) query.uniqueResult();
        }
        return result;
    }

    /**
     * Finds drive by name.
     *
     * @param type name.
     * @return WheelDrive.
     */
    public WheelDrive findWheelDriveByName(String type) {
        WheelDrive result;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from WheelDrive where type=:type");
            query.setParameter("type", type);
            result = (WheelDrive) query.uniqueResult();
        }
        return result;
    }

    /**
     * Add new advertisement to database.
     *
     * @param object new advertisement to add.
     */
    public void addAdvertisement(Advertisement object) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        }
    }

    /**
     * Updates advertisement in database.
     *
     * @param object advertisement to change.
     */
    public void updateAdvertisement(Advertisement object) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        }
    }

    /**
     * Add new car to database.
     *
     * @param object new car to add.
     */
    public void addCar(Car object) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        }
    }

    /**
     * Updates car in database.
     *
     * @param object new car to update.
     */
    public void updateCar(Car object) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        }
    }

    /**
     * Saves image in a database.
     */
    public void addImage(Image image) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(image);
            session.getTransaction().commit();
        }
    }

    /**
     * Add new engine to database.
     *
     * @param object new engine to add.
     */
    public void addEngine(Engine object) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        }
    }

    /**
     * Removes advertisement by id.
     *
     * @param id - id of advertisement ot remove.
     */
    public void deleteAdvertisementById(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(session.get(Advertisement.class, id));
            session.getTransaction().commit();
        }
    }

    /**
     * Receives all advertisements from database.
     *
     * @return list of advertisements.
     */
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

    /**
     * Receives list of brands from DB.
     *
     * @return list of brands.
     */
    public ArrayList<Brand> getBrands() {
        ArrayList<Brand> result = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List list = session.createQuery("from Brand").list();
            session.getTransaction().commit();
            if (!list.isEmpty()) {
                result = new ArrayList<>();
                for (Object adv : list) {
                    result.add((Brand) adv);
                }
            }
        }
        return result;
    }

    /**
     * Receives list of models from DB.
     *
     * @return list of models.
     */
    public ArrayList<Model> getModels() {
        ArrayList<Model> result = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List list = session.createQuery("from Model").list();
            session.getTransaction().commit();
            if (!list.isEmpty()) {
                result = new ArrayList<>();
                for (Object adv : list) {
                    result.add((Model) adv);
                }
            }
        }
        return result;
    }

    /**
     * Receives list of bodies from DB.
     *
     * @return list of bodies.
     */
    public ArrayList<BodyStyle> getBodyStyles() {
        ArrayList<BodyStyle> result = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List list = session.createQuery("from BodyStyle").list();
            session.getTransaction().commit();
            if (!list.isEmpty()) {
                result = new ArrayList<>();
                for (Object adv : list) {
                    result.add((BodyStyle) adv);
                }
            }
        }
        return result;
    }

    /**
     * Receives list of engines from DB.
     *
     * @return list of engines.
     */
    public ArrayList<Engine> getEngines() {
        ArrayList<Engine> result = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List list = session.createQuery("from Engine").list();
            session.getTransaction().commit();
            if (!list.isEmpty()) {
                result = new ArrayList<>();
                for (Object adv : list) {
                    result.add((Engine) adv);
                }
            }
        }
        return result;
    }

    /**
     * Receives list of transmissions from DB.
     *
     * @return list of transmissions.
     */
    public ArrayList<Transmission> getTransmissions() {
        ArrayList<Transmission> result = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List list = session.createQuery("from Transmission").list();
            session.getTransaction().commit();
            if (!list.isEmpty()) {
                result = new ArrayList<>();
                for (Object adv : list) {
                    result.add((Transmission) adv);
                }
            }
        }
        return result;
    }

    /**
     * Receives list of wheel drives from DB.
     *
     * @return list of wheel drives.
     */
    public ArrayList<WheelDrive> getWheelDrives() {
        ArrayList<WheelDrive> result = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List list = session.createQuery("from WheelDrive").list();
            session.getTransaction().commit();
            if (!list.isEmpty()) {
                result = new ArrayList<>();
                for (Object adv : list) {
                    result.add((WheelDrive) adv);
                }
            }
        }
        return result;
    }

    /**
     * Add new user to database.
     *
     * @param user user to add.
     */
    public void addUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    /**
     * Finds user by name.
     *
     * @param name search parameter.
     * @return User.
     */
    public User findUserByName(String name) {
        User result;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from User where name=:name");
            query.setParameter("name", name);
            result = (User) query.uniqueResult();
        }
        return result;
    }
}
