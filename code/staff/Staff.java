package staff;

import system.User;
import branch.Branch;
import branch.OrderManagement;

public class Staff implements User {
    public enum Gender {M, F};

    protected Branch branch;
    protected String loginId;
    protected String password = "password";
    protected String name;
    protected Gender gender;
    protected int age;

    protected OrderManagement orderManagement = new OrderManagement(this.branch);

    public Staff(Branch branch, String loginId, String name, Gender gender, int age) {
        this.branch = branch;
        this.loginId = loginId;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Branch getBranch() {
        return this.branch;
    }

    public String getId() {
        return this.loginId;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public void setId(String loginId) {
        this.loginId = loginId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(Gender newGender) {
        this.gender = newGender;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public void displayOrderList() {
        for (int i = 0; i <= this.branch.getOrderList().size(); i++) {
            ///

            ///
        }
    }

    public boolean viewOrder(int orderId) {
        ///

        ///
        return true;
    }

    public boolean processOrder(int orderId) {
        ///

        ///
        return true;
    }
}

