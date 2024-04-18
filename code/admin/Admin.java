package admin;

import staff.Staff.Gender;
import system.User;

public class Admin implements User {
    private String adminId;
    private String password = "password";
    private String name;
    private Gender gender;
    private int age;

    public Admin(String adminId, String name, Gender gender, int age) {
        this.adminId = adminId;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getId() {
        return this.adminId;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
