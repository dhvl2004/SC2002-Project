package staff;

import system.User;
import branch.Branch;
import branch.OrderManagement;

public class Staff extends User {
    protected Branch branch;
    protected OrderManagement orderManagement;

    public Staff(Branch branch, String staffId, String name, Gender gender, int age) {
        super(UserType.STAFF, staffId, name, gender, age);
        this.branch = branch;
        this.orderManagement = new OrderManagement(branch);
    }

    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
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

