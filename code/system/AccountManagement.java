package system;

public class AccountManagement {
    private Database database;

    public AccountManagement(Database database) {
        this.database = database;
    }

    public User find(String userId) {
        User user = null;
        for (int i = 0; i < this.database.accountList.size(); i++) {
            if (userId == this.database.accountList.get(i).getId()) {
                user = this.database.accountList.get(i);
                break;
            }
        }
        return user;
    }

    public boolean add(User user) {
        if (this.find(user.getId()) != null) {
            return false;
        }

        this.database.accountList.add(user);
        return true;
    }

    public User remove(String userId) {
        User user = this.find(userId);
        if (user == null || user instanceof Admin) {
            return null;
        }

        this.database.accountList.remove(user);
        return user;
    }
}
