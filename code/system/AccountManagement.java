package system;

import java.util.ArrayList;

public class AccountManagement {
    private ArrayList<User> accountList;

    public AccountManagement(ArrayList<User> accountList) {
        this.accountList = accountList;
    }

    public User find(String userId) {
        User user = null;
        for (int i = 0; i < this.accountList.size(); i++) {
            if (userId == this.accountList.get(i).getId()) {
                user = this.accountList.get(i);
                break;
            }
        }
        return user;
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
