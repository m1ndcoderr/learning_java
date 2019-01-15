package todolist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import todolist.models.Item;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 19.08.2017
 */
public class Controller {
    /**
     * This class.
     */
    private static final Controller CONTROLLER = new Controller();
    /**
     * Session factory.
     */
    private final SessionFactory sessionFactory = HibernateUtil.setUp();

    /**
     * Getter.
     *
     * @return this class.
     */
    public static Controller getCONTROLLER() {
        return CONTROLLER;
    }

    /**
     * Receives item by id from DB.
     *
     * @param id - id of searching item.
     * @return some item.
     */
    public Item findById(int id) {
        Item result;
        try (Session session = sessionFactory.openSession()) {
            result = (Item) session.get(Item.class, id);
        }
        return result;
    }

    /**
     * Receives item by description.
     *
     * @param description item's description.
     * @return Item object.
     */
    public Item findByDesc(String description) {
        Item result;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Item where description=:description");
            query.setParameter("description", description);
            result = (Item) query.uniqueResult();
        }
        return result;
    }

    /**
     * Add item to DB.
     *
     * @param description - some task to do.
     */
    public void add(String description) {

        Item item = new Item();
        item.setDesc(description);
        item.setCreated(new Timestamp(System.currentTimeMillis()));
        item.setDone(false);

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        }
    }

    /**
     * Updates string value of item in DB.
     *
     * @param id   - to find item to update.
     * @param desc - new description.
     */
    public void updateDesc(int id, String desc) {
        try (Session session = sessionFactory.openSession()) {
            Item item = session.get(Item.class, id);
            item.setDesc(desc);
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        }
    }

    /**
     * Changes boolean value of item in DB.
     *
     * @param id - to find item to update.
     */
    public void updateDone(int id) {
        try (Session session = sessionFactory.openSession()) {
            Item item = session.get(Item.class, id);
            if (item.isDone()) {
                item.setDone(false);
            } else {
                item.setDone(true);
            }
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        }
    }

    /**
     * Removes item by id.
     *
     * @param id - id of item ot remove.
     */
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(session.get(Item.class, id));
            session.getTransaction().commit();
        }
    }

    /**
     * Receives array of unfulfilled items (all not done items only).
     *
     * @return ArrayList.
     */
    public ArrayList<Item> getUnfulfilledItems() {
        ArrayList<Item> result = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List list = session.createQuery("from Item").list();
            session.getTransaction().commit();
            if (!list.isEmpty()) {
                int count = 0;
                for (Object obj : list) {
                    Item item = (Item) obj;
                    if (!item.isDone()) {
                        count++;
                    }
                }
                result = new ArrayList<>(count);
                for (Object ob : list) {
                    Item it = (Item) ob;
                    if (!it.isDone()) {
                        result.add(it);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Receives array of all items in DB.
     *
     * @return ArrayList.
     */
    public ArrayList<Item> getAllItems() {
        ArrayList<Item> result = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List list = session.createQuery("from Item").list();
            session.getTransaction().commit();
            if (!list.isEmpty()) {
                result = new ArrayList<>();
                for (Object item : list) {
                    result.add((Item) item);
                }
            }
        }
        return result;
    }
}
