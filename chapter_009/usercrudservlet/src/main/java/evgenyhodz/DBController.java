package evgenyhodz;

import evgenyhodz.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.05.2017
 */
public class DBController {
    /**
     * Connection for database.
     */
    private Connection connect = null;
    /**
     * For keeping properties.
     */
    private final Properties ps = new Properties();

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DBController.class);
    /**
     * LocalDate to String format.
     */
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Load properties for database.
     */
    public void loadProperties() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream("properties.txt")) {
            ps.load(resourceStream);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Set connection to database.
     */
    public void connect() {
        String url = ps.getProperty("url");
        String username = ps.getProperty("username");
        String password = ps.getProperty("password");
        try {
            connect = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Disconnect from database.
     */
    public void disconnect() {
        try {
            connect.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * Adding user to DB.
     *
     * @param u user for DB.
     */
    public void add(User u) {
        try (PreparedStatement st = connect.prepareStatement("INSERT INTO users(name, login, email, create_date) values(?,?,?,?)")) {
            st.setString(1, u.getName());
            st.setString(2, u.getLogin());
            st.setString(3, u.getEmail());
            st.setString(4, u.getCreateDate().format(formatter));
            st.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Update user in DB.
     *
     * @param u - user.
     */
    public void update(User u) {
        try (PreparedStatement st = connect.prepareStatement("UPDATE users SET name=?,email=?,create_date=? WHERE login=?")) {
            st.setString(1, u.getName());
            st.setString(2, u.getEmail());
            st.setString(3, LocalDate.now().format(formatter));
            st.setString(4, u.getLogin());
            st.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Delete user from DB.
     *
     * @param login login to delete.
     */
    public void delete(String login) {
        try (PreparedStatement st = connect.prepareStatement("DELETE FROM users WHERE login=?")) {
            st.setString(1, login);
            st.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Saving all data to ArrayList.
     *
     * @return ArrayList with users from DB.
     */
    public ArrayList<User> get() {
        ArrayList<User> result = new ArrayList<>();
        try (PreparedStatement st = connect.prepareStatement("SELECT * FROM users");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                result.add(new User(rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("email"),
                        LocalDate.parse(rs.getString("create_date"))));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }
}
