package evgenyhodz;

import evgenyhodz.models.Role;
import evgenyhodz.models.User;

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
     * LocalDate to String format.
     */
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Connection getConnect(){
        return connect;
    }

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
        try (PreparedStatement st = connect.prepareStatement("INSERT INTO users(name, login, email, create_date, role_id) values(?,?,?,?,?)")) {
            st.setString(1, u.getName());
            st.setString(2, u.getLogin());
            st.setString(3, u.getEmail());
            st.setString(4, u.getCreateDate().format(formatter));
            st.setInt(5, u.getRole().getId());
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
        try (PreparedStatement st = connect.prepareStatement("UPDATE users SET name=?,email=?,create_date=?, role_id=? WHERE login=?")) {
            st.setString(1, u.getName());
            st.setString(2, u.getEmail());
            st.setString(3, LocalDate.now().format(formatter));
            st.setString(5, u.getLogin());
            st.setInt(4, u.getRole().getId());
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
     * Adding new role to DB.
     *
     * @param roleName role's name.
     */
    public void addRole(String roleName) {
        try (PreparedStatement st = connect.prepareStatement("INSERT INTO roles(rolename) values(?)")) {
            st.setString(1, roleName);
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
        try (PreparedStatement st = connect.prepareStatement("UPDATE roles SET rolename=? WHERE role_id=?")) {
            st.setString(1, r.getName());
            st.setInt(2, r.getId());
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
        try (PreparedStatement st = connect.prepareStatement("DELETE FROM roles WHERE role_id=?")) {
            st.setInt(1, id);
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
        try (PreparedStatement st = connect.prepareStatement("SELECT u.name, u.login, u.email, u.create_date, r.role_id, r.rolename FROM users as u INNER JOIN roles as r on u.role_id = r.role_id");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                LocalDate local = LocalDate.parse(rs.getString("create_date"), formatter);
                result.add(new User(rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("email"),
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
        try (PreparedStatement st = connect.prepareStatement("SELECT * FROM roles");
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
        try (PreparedStatement st = connect.prepareStatement("SELECT u.name, u.login, u.email, u.create_date, r.role_id, r.rolename FROM users as u INNER JOIN roles as r on u.role_id = r.role_id WHERE login=?")) {
            st.setString(1, login);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    result = new User(
                            rs.getString("name"),
                            rs.getString("login"),
                            rs.getString("email"),
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
}
