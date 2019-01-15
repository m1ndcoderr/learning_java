package ru.evgenyhodz;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Properties;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 10.05.2017
 */
public class DBManager {
    /**
     * Connect reference.
     */
    private Connection connect;
    /**
     * For keeping properties.
     */
    private final Properties ps = new Properties();

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DBManager.class);

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
     * Fills DB with data.
     *
     * @param advertisements - ArrayDeque with references to advertisements.
     */
    public void fill(ArrayDeque<Advertisement> advertisements) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        while (!advertisements.isEmpty()) {
            Advertisement adv = advertisements.pollFirst();
            try {
                PreparedStatement ps = connect.prepareStatement("INSERT INTO ads (title, description, create_date) VALUES (?, ?, ?) ON CONFLICT (title) DO UPDATE SET create_date = EXCLUDED.create_date");
                ps.setString(1, adv.getTitle());
                ps.setString(2, adv.getDescription());
                ps.setString(3, df.format(adv.getDate()));
                ps.executeUpdate();
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Saving data to Logger.
     */
    public void info() {
        try (PreparedStatement st = connect.prepareStatement("SELECT * FROM ads;");
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                LOGGER.info(String.format("Title: %s, description: %s",
                        rs.getString("title"),
                        rs.getString("description")));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
