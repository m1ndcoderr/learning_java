package evgenyhodz;

import evgenyhodz.models.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
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
            e.printStackTrace();
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
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Error: " + e + "\n");
            e.printStackTrace();
        }
    }

    /**
     * Disconnect from database.
     */
    public void disconnect() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    e.printStackTrace();
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
            System.out.println("Error: " + e + "\n");
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    /**
     * Saving all data to ArrayList.
     *
     * @return ArrayList with users from DB.
     */
    public ArrayList<User> get() {
        loadProperties();
        connect();
        ArrayList<User> result = new ArrayList<>();
        try (PreparedStatement st = connect.prepareStatement("SELECT * FROM users");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                LocalDate local = LocalDate.parse(rs.getString("create_date"), formatter);
                result.add(new User(rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("email"),
                        local));
            }
            disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public User findByLogin(String login) {
        User result = null;
        try (PreparedStatement st = connect.prepareStatement("SELECT * FROM users WHERE login=?")) {
            st.setString(1, login);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    result = new User(
                            rs.getString("name"),
                            rs.getString("login"),
                            rs.getString("email"),
                            LocalDate.parse(rs.getString("create_date")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
