package admin;

import system.User;

public class Admin extends User {
    public Admin(String adminId, String name, Gender gender, int age) {
        super(UserType.ADMINISTRATOR, adminId, name, gender, age);
    }
}
