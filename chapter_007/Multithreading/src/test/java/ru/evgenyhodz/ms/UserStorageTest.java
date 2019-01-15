package ru.evgenyhodz.ms;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 23.03.2017
 */
public class UserStorageTest {
    private User user1;
    private User user2;
    private UserStorage storage;

    @Before
    public void setUp() {
        user1 = new User("user1", 1);
        user2 = new User("user2", 2);
        storage = new UserStorage();
        storage.add(user1);
        storage.add(user2);
    }

    @Test
    public void whenDeleteFromStorageThenGetNull() {
        storage.delete("user1");
        assertNull(storage.read("user1"));
    }

    @Test
    public void whenEditAmountThenGetUpdatedAmount() {
        storage.edit("user1", 100);
        assertThat(storage.read("user1"), is(100));
    }

    @Test
    public void whenSendMoneyFromOneUserToAnother() {
        storage.transfer("user1", "user2", 1);
        assertThat(storage.read("user2"), is(3));
    }

}