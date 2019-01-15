package ru.evgenyhodz.lite;

import java.util.HashMap;
import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 17.03.2017
 */
public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
