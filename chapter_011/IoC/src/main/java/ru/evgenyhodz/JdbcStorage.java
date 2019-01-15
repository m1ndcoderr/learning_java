package ru.evgenyhodz;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 17.08.2017
 */
public class JdbcStorage implements Storage {
    /**
     * Log4j logger.
     */
    private static final Logger LOG = Logger.getLogger(JdbcStorage.class);

    /**
     * JdbcTemplate.
     */
    private JdbcTemplate jdbcTemplate;

    /**
     * * Constructor.
     *
     * @param temp jdbc template.
     */
    public JdbcStorage(JdbcTemplate temp) {
        this.jdbcTemplate = temp;
    }

    /**
     * Adds user to storage.
     *
     * @param user user.
     */
    @Override
    public void add(User user) {
        try {
            this.jdbcTemplate.update("INSERT INTO springusers(name) values(?)", user.getName());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Sets new JdbcTemplate..
     *
     * @param jdbcTemplate New value of JdbcTemplate..
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Gets JdbcTemplate..
     *
     * @return Value of JdbcTemplate..
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
