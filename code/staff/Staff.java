package staff;

import branch.Branch;
import branch.OrderManagement;

public class Staff {
    public enum Gender {M, F};

    protected Branch branch;
    protected String staffId;
    protected String staffName;
    protected String password = "password";
    protected Gender gender;
    protected int age;

    protected OrderManagement orderManagement = new OrderManagement(this.branch);

    public Staff(Branch branch, String staffId, String staffName, Gender gender, int age) {
        this.branch = branch;
        this.staffId = staffId;
        this.staffName = staffName;
        this.gender = gender;
        this.age = age;
    }

    public Branch getBranch() {
        return this.branch;
    }

    public String getStaffId() {
        return this.staffId;
    }

    public String getStaffName() {
        return this.staffName;
    }

    public String getPassword() {
        return this.password;
    }

    public Gender getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setBranch(Branch newBranch) {
        this.branch = newBranch;
    }

    public void setStaffId(String newStaffId) {
        this.staffId = newStaffId;
    }

    public void setStaffName(String newStaffName) {
        this.staffName = newStaffName;
    }

    public boolean setPassword(String newPassword) {
        if (newPassword == this.password) return false;
        this.password = newPassword;
        return true;
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

