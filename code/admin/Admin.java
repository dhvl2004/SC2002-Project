package admin;

import system.User;

public class Admin extends User {
    public Admin(String adminId, String password, String name, Gender gender, int age, String branchName) {
    	super(UserType.ADMINISTRATOR, adminId, password, name, gender, age, branchName);
    }
}
