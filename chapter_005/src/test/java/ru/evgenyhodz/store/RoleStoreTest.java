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
public class RoleStoreTest {
    /**
     * Ref to RoleStore object.
     */
    private RoleStore roleStore;
    /**
     * Ref to Role object.
     */
    private Role role;

    /**
     * Create objects for tests.
     */
    @Before
    public void createObjectsForTests() {
        roleStore = new RoleStore();
        role = new Role();
        role.setId("1");
        roleStore.add(role);
    }

    /**
     * Checking, that object is in the store.
     */
    @Test
    public void whenGetUserByIdThenGetSomeUserTest() {
        assertThat(roleStore.get("1"), is(this.role));
    }

    /**
     * When there is no such id then get the exception message.
     */
    @Test
    public void whenGetUserByWrongIdThenGetException() {
        try {
            assertThat(roleStore.get("2"), is(this.role));
        } catch (NoSuchElementException e) {
            assertThat(e.getMessage(), is("There is no such User."));
        }
    }

    /**
     * Checking update method.
     */
    @Test
    public void whenUpdateOldValueThenGetNewValueInsteadTest() {
        Role another = new Role();
        another.setId("3");
        roleStore.update("1", another);
        assertThat(this.roleStore.get("3"), is(another));
    }

    /**
     * Checking update method.
     */
    @Test
    public void whenDeleteValueInStoreThenGetEmptyCellTest() {
        this.roleStore.delete("1");
        try {
            roleStore.get("1");
        } catch (NoSuchElementException e) {
            assertThat(e.getMessage(), is("There is no such User."));
        }
    }
}