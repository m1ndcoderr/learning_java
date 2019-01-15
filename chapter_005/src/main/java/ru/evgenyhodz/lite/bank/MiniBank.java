package ru.evgenyhodz.lite.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 23.03.2017
 */
public class MiniBank {
    /**
     * Storage
     */
    private HashMap<User, List<Account>> base = new HashMap<>();

    /**
     * Add user to storage
     *
     * @param user - user
     */
    public void addUser(User user) {
        if (!base.containsKey(user)) {
            base.put(user, null);
        }
    }

    /**
     * Delete user
     *
     * @param user - user to delete
     */
    public void deleteUser(User user) {
        if (base.containsKey(user)) {
            base.remove(user);
        }
    }

    /**
     * Add account to user
     *
     * @param user    user
     * @param account account
     */
    public void addAccountToUser(User user, Account account) {
        if (base.containsKey(user)) {
            if (base.get(user) == null) {
                List<Account> accounts = new ArrayList<>();
                accounts.add(account);
                base.put(user, accounts);
            } else {
                base.get(user).add(account);
            }
        }
    }

    /**
     * Delete account of user
     *
     * @param user    user
     * @param account account
     */
    public void deleteAccountFromUser(User user, Account account) {
        if (base.containsKey(user) && base.get(user) != null) {
            if (base.get(user).contains(account)) {
                base.get(user).remove(account);
            }
        }
    }

    /**
     * Returns account list of user.
     *
     * @param user user
     * @return list of accounts.
     */
    public List<Account> getUserAccounts(User user) {
        List<Account> result = null;
        if (base.containsKey(user) && base.get(user) != null) {
            result = base.get(user);
        }
        return result;
    }

    /**
     * Transfering money from one user's account to another user's account.
     * To make a transfer we need requisites of both users.
     *
     * @param srcUser       user to transfer from
     * @param srcRequisites requisites of user to make transfer
     * @param dstUser       user to transfer to
     * @param dstRequisites requisites of user to make transfer
     * @param amount        - amount of money
     * @return boolean
     */
    public boolean transferMoney(User srcUser,
                                 Integer srcRequisites,
                                 User dstUser,
                                 Integer dstRequisites,
                                 double amount) {
        boolean result = false;
        if (base.containsKey(srcUser) && base.containsKey(dstUser)) {
            if (enoughFunds(srcUser, srcRequisites, amount)) {
                if (base.get(srcUser) != null && base.get(dstUser) != null) {
                    List<Account> src = base.get(srcUser);
                    for (Account value : src) {
                        if (srcRequisites.equals(value.getRequisites())) {
                            List<Account> dst = base.get(dstUser);
                            for (Account val : dst) {
                                if (dstRequisites.equals(val.getRequisites())) {
                                    value.setValue(value.getValue() - amount);
                                    val.setValue(value.getValue() + amount);
                                    result = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Checks if there are enough money to make a transfer.
     *
     * @param src           - user
     * @param srcRequisites - user's requisites
     * @param amount        - money to transfer
     * @return - boolean
     */
    private boolean enoughFunds(User src, Integer srcRequisites, double amount) {
        boolean result = true;
        for (Account account : base.get(src)) {
            if (account.getRequisites().equals(srcRequisites)) {
                if (account.getValue() - amount < 0) {
                    result = false;
                    System.out.println("Not enough money for transfer.");
                }
            }
        }
        return result;
    }
}

