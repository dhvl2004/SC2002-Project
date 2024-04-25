package staff;

import system.User;
import branch.Branch;
import branch.OrderManagement;


/**
 * <li>This Class extends from User Class.
 * <li>It is a specialized version of User, represents the Staff Actor with access to view, process and display orders by customers
 * @author FDAB 2
 * @version 1.0
 */
public class Staff extends User {
	/**
	 * Attribute representing the Branch the staff if located at
	 */
    protected Branch branch;
    
    /**
     * Attribute representing the Current Orders made by Customers at the current Branch staff is located at
     */
    protected OrderManagement orderManagement;

    
    /**
     * Staff constructor that calls base-class user's constructor
     * @param branch Branch staff is located in
     * @param staffId StaffId that identifies the Staff
     * @param password Staff's Password
     * @param name Name of the Staff
     * @param gender Gender of the Staff
     * @param age Age of the Staff
     */
    public Staff(Branch branch, String staffId, String password, String name, Gender gender, int age) {
        super(UserType.STAFF, staffId, password, name, gender, age, branch.getBranchName());
        this.branch = branch;
        this.orderManagement = new OrderManagement(branch);
    }

    
    /**
     * Getter method to return the branch the staff is located in
     * @return Returns Branch object of the Staff
     */
    public Branch getBranch() {
        return this.branch;
    }

    
    /**
     * Setter method to dictate which Branch the staff is currently located in
     * @param branch Branch object of intended Branch for the Staff
     */
    public void setBranch(Branch branch) {
        this.branch = branch;
        this.branchName = branch.getBranchName();
    }

    
    /**
     * Method for displaying all orders in the Branch
     */
    public void displayOrderList() {
        for (int i = 0; i <= this.branch.getOrderList().size(); i++) {
            ///

            ///
        }
    }

    
    /**
     * Method to view a specific order made by a customer 
     * @param orderId OrderId to be viewed
     * @return Return True if order exist and can be displayed
     */
    public boolean viewOrder(int orderId) {
        ///

        ///
        return true;
    }

    
    /**
     * Method to allow staff to process the customer's order for payment
     * @param orderId OrderID to be processed
     * @return Returns True if order exists and process if successful
     */
    public boolean processOrder(int orderId) {
        ///

        ///
        return true;
    }
}

