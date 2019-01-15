package carstore.controllers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 19.08.2017
 */
public class HibernateUtil {
    /**
     * Link to Session factory.
     */
    private static SessionFactory sessionFactory = null;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * Creates session factory.
     *
     * @return session factory.
     */
    public static SessionFactory setUp() {
        return sessionFactory;
    }
}
