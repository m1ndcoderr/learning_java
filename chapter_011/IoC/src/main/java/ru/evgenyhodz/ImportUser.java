package ru.evgenyhodz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 21.08.2017
 */
public class ImportUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        JdbcStorage jdbcStorage = (JdbcStorage) context.getBean("jdbc");
        MemoryStorage memoryStorage = (MemoryStorage) context.getBean("memory");

        User user = new User("Vasya Petrov");


        try {
            Connection connection = jdbcStorage.getJdbcTemplate().getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // jdbcStorage.add(user);


    }
}
