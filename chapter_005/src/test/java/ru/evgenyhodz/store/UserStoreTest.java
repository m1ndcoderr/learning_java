package ru.evgenyhodz.store;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 09.02.2017
 */
public class UserStoreTest {
    /**
     * Ref to storage object.
     */
    private UserStore userStore;
    /**
     * Ref to User's object.
     */
    private User user;

    /**
     * Create objects for tests.
     */
    @Before
    public void createObjectsForTests() {
        userStore = new UserStore();
        user = new User();
        user.setId("1");
        userStore.add(user);
    }

    /**
     * Checking, that object is in the store.
     */
    @Test
    public void whenGetUserByIdThenGetSomeUserTest() {
        assertThat(userStore.get("1"), is(this.user));
    }

    /**
     * When there is no such id then get the exception message.
     */
    @Test
    public void whenGetUserByWrongIdThenGetException() {
        try {
            assertThat(userStore.get("2"), is(this.user));
        } catch (NoSuchElementException e) {
            assertThat(e.getMessage(), is("There is no such User."));
        }
    }

    /**
     * Checking update method.
     */
    @Test
    public void whenUpdateOldValueThenGetNewValueInsteadTest() {
        User another = new User();
        another.setId("3");
        userStore.update("1", another);
        assertThat(this.userStore.get("3"), is(another));
    }

    /**
     * Checking update method.
     */
    @Test
    public void whenDeleteValueInStoreThenGetEmptyCellTest() {
        this.userStore.delete("1");
        try {
            userStore.get("1");
        } catch (NoSuchElementException e) {
            assertThat(e.getMessage(), is("There is no such User."));
        }
    }
}