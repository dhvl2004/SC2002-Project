package staff;

import branch.Branch;
import branch.OrderManagement;

public class Staff {
    protected Branch branch;
    protected int staffId;
    protected String password = "password";
    protected boolean isMale;
    protected int age;

    protected OrderManagement orderManagement = new OrderManagement(this.branch);

    public Staff(Branch branch, int staffId, boolean isMale, int age) {
        this.branch = branch;
        this.staffId = staffId;
        this.isMale = isMale;
        this.age = age;
    }

    public Branch getBranch() {
        return this.branch;
    }

    public int getStaffId() {
        return this.staffId;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean getIsMale() {
        return this.isMale;
    }

    public int getAge() {
        return this.age;
    }

    public void setBranch(Branch newBranch) {
        this.branch = newBranch;
    }

    public void setStaffId(int newStaffId) {
        this.staffId = newStaffId;
    }

    public boolean setPassword(String newPassword) {
        if (newPassword == this.password) return false;
        this.password = newPassword;
        return true;
    }

    public void setIsMale(boolean newIsMale) {
        this.isMale = newIsMale;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public void displayOrderList() {
        for (int i = 0; i <= this.branch.getOrderList(); i++) {
            ///

            ///
        }
    }

    public boolean viewOrder(int orderId) {
        ///

        ///
    }

    public boolean processOrder(int orderId) {
        ///

        ///
    }
}
