package ru.evgenyhodz.lite.bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 25.03.2017
 */
public class MiniBankTest {

    private MiniBank bank;
    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private Account a;
    private Account b;

    @Before
    public void create() {
        bank = new MiniBank();
        user1 = new User("user1", null);
        user2 = new User("user2", null);
        user3 = new User("user3", null);
        user4 = new User("user4", null);
        a = new Account(100D, 123);
        b = new Account(200D, 321);
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user4);
        bank.addAccountToUser(user1, new Account(100D, 987654321));
        bank.addAccountToUser(user2, new Account(0D, 123456789));
        bank.addAccountToUser(user4, a);
        bank.addAccountToUser(user4, b);
    }

    /**
     * Transfer test
     */
    @Test
    public void whenTransferMoneyFromOneUserToAnotherThenGetResults() {
        bank.transferMoney(user1, 987654321, user2, 123456789, 100D);
        assertThat(bank.getUserAccounts(user2).get(0).getValue(), is(100D));
    }

    /**
     * Not enough money
     */
    @Test
    public void whenNotEnoughMoneyForTransferThenGetFalseAndMessage() {
        boolean result = bank.transferMoney(user2, 123456789, user1, 987654321, 100D);
        assertThat(result, is(false));
    }

    /**
     * Cannot find user
     */
    @Test
    public void whenCannotFindUserThenGetFalse() {
        boolean result = bank.transferMoney(user3, null, user2, 123456789, 10D);
        assertThat(result, is(false));
    }

    /**
     * Deleting user
     */
    @Test
    public void whenDeleteUser() {
        bank.deleteUser(user1);
        assertNull(bank.getUserAccounts(user1));
    }

    /**
     * Getting list of accounts
     */
    @Test
    public void whenGetListOfAccounts() {
        assertThat(bank.getUserAccounts(user4).size(), is(2));
    }

    /**
     * Deleting account from user
     */
    @Test
    public void whenDeleteAccount() {
        bank.deleteAccountFromUser(user4, b);
        int size = bank.getUserAccounts(user4).size();
        assertThat(size, is(1));
    }
}