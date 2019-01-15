package usersdatabase;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import usersdatabase.models.Role;
import usersdatabase.models.User;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
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
     * To avoid 'magic' number mistake creating by checkstyle plugin.
     */
    private static final int THREE = 3, FOUR = 4, FIVE = 5,
            SIX = 6, SEVEN = 7, ONE = 1, TWO = 2;
    /**
     * For keeping properties.
     */
    private final Properties ps = new Properties();
    /**
     * Pool of connections.
     */
    private static ComboPooledDataSource ds;
    /**
     * Instance of this class.
     */
    private static final DBController DBCONTROLLER = new DBController();

    /**
     * LocalDate to String format.
     */
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Getter.
     *
     * @return DBController object.
     */
    public static DBController getController() {
        return DBCONTROLLER;
    }

    /**
     * Sources initialisation.
     */
    private static void createSources() {
        ds = new ComboPooledDataSource();
        Properties prop = new Properties();
        try (InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("properties.txt")) {
            prop.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ds.setDriverClass(prop.getProperty("driverClass"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        ds.setUser(prop.getProperty("username"));
        ds.setPassword(prop.getProperty("password"));
        ds.setJdbcUrl(prop.getProperty("url"));
        ds.setMinPoolSize(Integer.parseInt(prop.getProperty("minSize")));
        ds.setMaxPoolSize(Integer.parseInt(prop.getProperty("maxSize")));
        ds.setMaxIdleTime(Integer.parseInt(prop.getProperty("maxIdleTime")));
    }

    /**
     * Set connection to database.
     *
     * @return Connection object.
     * @throws SQLException .
     */
    private Connection connect() throws SQLException {
        if (ds == null) {
            createSources();
        }
        return ds.getConnection();
    }

    /**
     * Adding user to DB.
     *
     * @param u user for DB.
     */
    public void add(User u) {
        try (PreparedStatement st = connect().prepareStatement("INSERT INTO users(name, login, email, country, city, create_date, role_id) values(?,?,?,?,?,?,?)")) {
            st.setString(ONE, u.getName());
            st.setString(TWO, u.getLogin());
            st.setString(THREE, u.getEmail());
            st.setString(FOUR, u.getCountry());
            st.setString(FIVE, u.getCity());
            st.setString(SIX, u.getCreateDate().format(formatter));
            st.setInt(SEVEN, u.getRole().getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Update user in DB.
     *
     * @param u - user.
     */
    public void update(User u) {
        try (PreparedStatement st = connect().prepareStatement("UPDATE users SET name=?,email=?, country=?, city=?, create_date=?, role_id=? WHERE login=?")) {
            st.setString(ONE, u.getName());
            st.setString(TWO, u.getEmail());
            st.setString(THREE, u.getCountry());
            st.setString(FOUR, u.getCity());
            st.setString(FIVE, LocalDate.now().format(formatter));
            st.setInt(SIX, u.getRole().getId());
            st.setString(SEVEN, u.getLogin());
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
        try (PreparedStatement st = connect().prepareStatement("DELETE FROM users WHERE login=?")) {
            st.setString(ONE, login);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes user by name.
     * @param username - name.
     */
    public void deleteByName(String username) {
        try (PreparedStatement st = connect().prepareStatement("DELETE FROM users WHERE name=?")) {
            st.setString(ONE, username);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adding new role to DB.
     *
     * @param roleName role's name.
     */
    public void addRole(String roleName) {
        try (PreparedStatement st = connect().prepareStatement("INSERT INTO roles(rolename) values(?)")) {
            st.setString(ONE, roleName);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Update role in DB.
     *
     * @param r - role.
     */
    public void updateRole(Role r) {
        try (PreparedStatement st = connect().prepareStatement("UPDATE roles SET rolename=? WHERE role_id=?")) {
            st.setString(ONE, r.getName());
            st.setInt(TWO, r.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete role by id.
     *
     * @param id id of role to find.
     */
    public void deleteRole(int id) {
        try (PreparedStatement st = connect().prepareStatement("DELETE FROM roles WHERE role_id=?")) {
            st.setInt(ONE, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Saving all data to ArrayList.
     *
     * @return ArrayList with users from DB.
     */
    public ArrayList<User> get() {
        ArrayList<User> result = new ArrayList<>();
        try (PreparedStatement st = connect().prepareStatement("SELECT u.name, u.login, u.email, u.create_date, u.country, u.city, r.role_id, r.rolename FROM users as u INNER JOIN roles as r on u.role_id = r.role_id");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                LocalDate local = LocalDate.parse(rs.getString("create_date"), formatter);
                result.add(new User(rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("country"),
                        rs.getString("city"),
                        local,
                        new Role(rs.getInt("role_id"), rs.getString("rolename"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Gets all roles from DB.
     *
     * @return ArrayList<Role> container with roles.
     */
    public ArrayList<Role> getRoles() {
        ArrayList<Role> result = new ArrayList<>();
        try (PreparedStatement st = connect().prepareStatement("SELECT * FROM roles");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                result.add(new Role(rs.getInt("role_id"), rs.getString("rolename")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Find user by login.
     *
     * @param login login to find by.
     * @return some User.
     */
    public User findByLogin(String login) {
        User result = null;
        try (PreparedStatement st = connect().prepareStatement("SELECT u.name, u.login, u.email, u.create_date, u.country, u.city, r.role_id, r.rolename FROM users as u INNER JOIN roles as r on u.role_id = r.role_id WHERE login=?")) {
            st.setString(1, login);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    result = new User(
                            rs.getString("name"),
                            rs.getString("login"),
                            rs.getString("email"),
                            rs.getString("country"),
                            rs.getString("city"),
                            LocalDate.parse(rs.getString("create_date")),
                            new Role(rs.getInt("role_id"), rs.getString("rolename")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Find role by id.
     *
     * @param id id to find by.
     * @return some Role.
     */
    public Role findRoleById(int id) {
        Role result = null;
        for (Role role : getRoles()) {
            if (role.getId() == id) {
                result = role;
                break;
            }
        }
        return result;
    }

    /**
     * Find role by id.
     *
     * @param name id to find by.
     * @return some Role.
     */
    public Role findRoleByName(String name) {
        Role result = null;
        for (Role role : getRoles()) {
            if (role.getName().equals(name)) {
                result = role;
                break;
            }
        }
        return result;
    }

    /**
     * Get user by login.
     *
     * @param login login.
     * @return some user.
     */
    public User getUser(String login) {
        User result = null;
        for (User user : get()) {
            if (user.getLogin().equals(login)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Checks if such email already exists.
     *
     * @param email - email to check.
     * @return boolean value.
     */
    public boolean isEmailExists(String email) {
        boolean result = false;
        for (User user : get()) {
            if (user.getEmail().equals(email)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Checks existing of some user by name and login.
     *
     * @param username - name of a user.
     * @param login    - login of a user.
     * @return true/false.
     */
    public boolean isCredentional(String username, String login) {
        boolean exist = false;
        for (User user : get()) {
            if (user.getName().equals(username) && user.getLogin().equals(login)) {
                exist = true;
                break;
            }
        }
        return exist;
    }
}
