package ru.evgenyhodz.lite;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 17.03.2017
 */
public class UserConvertTest {

    @Test
    public void whenConvertListToMapThenGetResultMap() {
        List<User> list = new ArrayList<>();
        User user = new User(1, "Vasya", "Moscow");
        list.add(user);
        UserConvert uc = new UserConvert();
        HashMap<Integer, User> test = uc.process(list);
        assertThat(test.get(1), is(user));
    }
}