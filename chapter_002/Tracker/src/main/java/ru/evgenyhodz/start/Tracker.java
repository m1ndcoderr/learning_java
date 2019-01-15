package ru.evgenyhodz.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.evgenyhodz.models.Application;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

/**
 * Class contains methods to manage our applications.
 *
 * @author Evgeny Khodzitskiy.
 */
public class Tracker {
    /**
     * Object to generate random values.
     */
    private static final Random rand = new Random();
    /**
     * For keeping properties.
     */
    private final Properties ps = new Properties();
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Tracker.class);
    /**
     * Reference to connection object.
     */
    private Connection connect;

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
    public void connectToDatabase() {
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
    public void disconnectFromDatabase() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
     * Creates tables if they do not exist.
     */
    public void createTablesIfNotExists() {
        try {
            Statement statement = connect.createStatement();
            //TODO - SQL dialect is not configured below.
            statement.execute("CREATE TABLE IF NOT EXISTS applications (app_id serial PRIMARY KEY, name VARCHAR(100), description TEXT,create_date TIMESTAMP);");
            statement.execute("CREATE TABLE IF NOT EXISTS comments (comm_id serial PRIMARY KEY, comm TEXT, app_id INTEGER REFERENCES applications (app_id));");
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }


    /**
     * Creates application with unique ID and current creation date.
     *
     * @param app - application to add.
     * @return - application.
     */
    public void addApp(Application app) {
        app.setId(this.generateId());
        app.setCreationDate(this.setCurrentDate());
        try {
            PreparedStatement ps = connect.prepareStatement("INSERT INTO applications (app_id, create_date) VALUES (?, ?)");
            ps.setString(1, app.getId());
            ps.setString(2, app.getCreationDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Edit the application we created before.
     *
     * @param fresh - application to change.
     */
    public void editApp(Application fresh) {
        try {
            PreparedStatement ps = connect.prepareStatement("UPDATE applications SET name=?, description=?, create_date=? WHERE app_id=?");
            ps.setString(1, fresh.getName());
            ps.setString(2, fresh.getDescription());
            ps.setString(3, fresh.getCreationDate());
            ps.setString(4, fresh.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Delete application from DB by id.
     *
     * @param id - id of application.
     */
    public void deleteApp(String id) {
        try (PreparedStatement pst = connect.prepareStatement("DELETE FROM applications WHERE app_id=?")) {
            pst.setString(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Show all application in our storage.
     *
     * @return - application's HashMap.
     */
    public HashMap<String, Application> showApps() {
        HashMap<String, Application> result = new HashMap<>();
        try (PreparedStatement prs = connect.prepareStatement("SELECT * FROM applications");
             ResultSet resultSet = prs.executeQuery()) {
            while (resultSet.next()) {
                Application app = new Application(
                        resultSet.getString("app_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("creation_date"));
                result.put(resultSet.getString("app_id"), app);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Show application by unique id.
     *
     * @param id - special number.
     * @return - application.
     */
    public Application showById(String id) {
        Application result = null;
        try (PreparedStatement prs = connect.prepareStatement("SELECT * FROM applications WHERE app_id=?")) {
            prs.setString(1, id);
            try (ResultSet resultSet = prs.executeQuery()) {
                if (resultSet.next()) {
                    result = new Application(
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getString("create_date"));
                    result.setId(resultSet.getString("app_id"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Generates unique id number after adding the application to array.
     *
     * @return string value - id.
     */
    private String generateId() {
        int min = 1, max = 99;
        int diff = max - min;
        int num = rand.nextInt(diff + 1);
        num += min;
        return String.valueOf(num);
    }

    /**
     * Show application by name.
     *
     * @param name - name of application to show.
     * @return application object.
     */
    public Application showByName(String name) {
        Application result = null;
        try (PreparedStatement prs = connect.prepareStatement("SELECT * FROM applications WHERE name=?")) {
            prs.setString(1, name);
            try (ResultSet resultSet = prs.executeQuery()) {
                if (resultSet.next()) {
                    result = new Application(
                            resultSet.getString("app_id"),
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getString("create_date"));
                    result.setName(resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Delete application by name.
     *
     * @param name - name of application to delete.
     */
    public void deleteAppByName(String name) {
        try (PreparedStatement pst = connect.prepareStatement("DELETE FROM applications WHERE name=?")) {
            pst.setString(1, name);
            pst.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Shows the String array of all IDs of all applications we have.
     *
     * @return string array.
     */
    public ArrayList<String> showAllIDs() {
        ArrayList<String> ids = null;
        try (PreparedStatement prs = connect.prepareStatement("SELECT * FROM applications");
             ResultSet resultSet = prs.executeQuery()) {
            ids = new ArrayList<>(resultSet.getMetaData().getPrecision(1));
            while (resultSet.next()) {
                ids.add(resultSet.getString("app_id"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return ids;
    }

    /**
     * Shows the String array of all names of all applications we have.
     *
     * @return string array.
     */
    public ArrayList<String> showAllNames() {
        ArrayList<String> names = null;
        try (PreparedStatement prs = connect.prepareStatement("SELECT * FROM applications");
             ResultSet resultSet = prs.executeQuery()) {
            names = new ArrayList<>(resultSet.getMetaData().getPrecision(2));
            while (resultSet.next()) {
                names.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return names;
    }

    /**
     * Show all data.
     */
    public void printOnScreen() {
        HashMap<String, Application> toPrint = showApps();
        int var = 0;
        for (Map.Entry<String, Application> entry : toPrint.entrySet()) {
            System.out.println("Application-" + ++var + ":\n" +
                    "Key: " + entry.getKey() +
                    " User: " + entry.getValue().getName() +
                    " Description: " + entry.getValue().getDescription() +
                    " Create date: " + entry.getValue().getCreationDate());
        }
    }

    /**
     * Set current date automatically after adding of application.
     *
     * @return string value - date.
     */
    public String setCurrentDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
    }
}
