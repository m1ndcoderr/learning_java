package todolist;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 20.08.2017
 */
public class HibernateUtilTest {
    /**
     * Set up test.
     */
    @Test
    public void whenCreateClassWhenCanGetSessionFactory() {
        assertNotNull(HibernateUtil.setUp());
    }

}