package system;

import java.util.ArrayList;

import admin.Admin;

public class AccountManagement {
    private ArrayList<User> accountList;

    public AccountManagement(ArrayList<User> accountList) {
        this.accountList = accountList;
    }

    public User find(String userId) {
        for (User account : accountList) {
            if (userId.equals(account.getId())) {
                return account;
            }
        }
        return null;
    }

    public boolean add(User user) {
        if (this.find(user.getId()) != null) {
            return false;
        }

        this.accountList.add(user);
        return true;
    }

    public User remove(String userId) {
        User user = this.find(userId);
        if (user == null || user instanceof Admin) {
            return null;
        }

        this.accountList.remove(user);
        return user;
    }
}
