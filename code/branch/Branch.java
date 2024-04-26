package branch;

import java.util.ArrayList;
import item.Item;
import order.Order;
import staff.Staff;
import staff.Manager;

/**
 * <li>Class representing branch of the Fast-Food chain
 * <li>The branch is of entity stereotype and composes of other classes and actors like staff and customer
 * <li>This class serves more as a all-encompompassing tool to host operations and users within a fast-food branch
 * @author FDAB 2
 * @version 1.0
 * 
 */
public class Branch {
	
	/**
	 * Class object representing if the branch is closed or open
	 * <li>A branch being closed is to be differentiated from a branch being "shut down"
	 * <li> Certain attributes like all the branch's staff and menu remain when the branch is closed.Preventing the need to re-initialize upon opening branch at opening hours
	 * 
	 */
    public enum OperationStatus {OPEN, CLOSE};

    
    /**
     * Name of the Branch
     */
    private String branchName;
    
    /**
     * Location of the branch
     */
    private String branchLocation;

    
    /**
     * Limit to the number of staff that can be employed at the Branch
     */
    private int staffQuota;
    
    /**
     * <li>Limit to the number of managers that can be employed at the Branch
     * <li> This Manager limit depends on the quantity of Staff
     */
    private int managerQuota = 0;

    
   
    private OperationStatus operationStatus = OperationStatus.OPEN;
    
    /**
     * Represents the operating hours of the branch
     */
    private int openingHour = 800, closingHour = 2200;
        
    
    /**
     * list of all staff working at the branch
     */
    ArrayList<Staff> staffList = new ArrayList<Staff>();
    
    /**
     * List of all managers working a the branch
     */
    ArrayList<Manager> managerList = new ArrayList<Manager>();
    
    /**
     * List of all food items available at the branch
     */
    ArrayList<Item> itemList = new ArrayList<Item>();
    
    /**
     * List of all existing orders by customers within the branch
     */
    ArrayList<Order> orderList = new ArrayList<Order>();
    
    /**
     * Represents the total current orders made by all customers at the Branch
     */
    private int orderId = 0;

    
    /**
     * <li>Constructor for Branch class
     * <li> Instantiation means a new branch has been built
     * @param branchName Name of the Branch
     * @param branchLocation Location of the Branch
     * @param staffQuota Maximum limit for the number of Staff
     */
    public Branch(String branchName, String branchLocation, int staffQuota) {
        this.branchName = branchName;
        this.branchLocation = branchLocation;
        this.staffQuota = staffQuota;
        calculateManagerQuota();
    }
    
    /**
     * <li>Constructor for Branch class
     * <li> Instantiation means a new branch has been built
     * @param branchName Name of Branch
     * @param branchLocation Location of Branch
     * @param staffQuota Maximum limit for the number of Staff
     * @param operationStatus Represents if the branch is currently open or closed
     */
    public Branch(String branchName, String branchLocation, int staffQuota, OperationStatus operationStatus) {
		this.operationStatus = operationStatus;
		this.branchName = branchName;
    	this.branchLocation = branchLocation;
    	this.staffQuota = staffQuota;
    	calculateManagerQuota();
    }

    
    /**
     * Calculates the max number of Manager allowed based on the number of current staff employed
     * <li>The method then updates the attribute of the Branch and sets a limit to number of managers
     */
    private void calculateManagerQuota() {
        int[] managerQuotaThreshold = { 1, 5, 9 };
        int[] managerQuotaList = { 1, 2, 3 };
        this.managerQuota = 0;
        for (int i = 0; i < managerQuotaThreshold.length; i++) {
            if (this.staffQuota <= managerQuotaThreshold[i]) {
                this.managerQuota = managerQuotaList[i];
                break;
            }
        }
        if (this.managerQuota == 0) {
            this.managerQuota = managerQuotaList[managerQuotaList.length - 1];
        }
    }

    
    /**
     * Getter method for Name of Branch
     * @return Name of Branch
     */
    public String getBranchName() {
        return this.branchName;
    }

    
    /**
     * Getter method for retrieving  Location of Branch
     * @return Location of Branch as a string
     */
    public String getBranchLocation() {
        return this.branchLocation;
    }

    
    /**
     * Getter method for retrieving staff quota of branch
     * @return Staff quota as an integer
     */
    public int getStaffQuota() {
        return this.staffQuota;
    }

    
    /**
     * Getter method for retrieving Manager quota of branch
     * @return Manager quota as an integer
     */
    public int getManagerQuota() {
        return this.managerQuota;
    }

    
    /**
     * Getter method for retrieving operation status  of branch
     * @return Operation status of branch, representing if the branch is open or closed
     */
    public OperationStatus getOperationStatus() {
        return this.operationStatus;
    }

    
    /**
     * Getter method for retrieving Opening Hours of branch
     * @return Opening Hour as an integer
     * @return
     */
    public int getOpeningHour() {
        return this.openingHour;
    }

    
    /**
     * Getter method for retrieving Closing Hours of branch
     * @return Closing Hour as an integer
     */
    public int getClosingHour() {
        return this.closingHour;
    }

    
    /**
     * Getter method for retrieving all staff employed at the Branch
     * @return arrayList of staff list
     */
    public ArrayList<Staff> getStaffList() {
        return this.staffList;
    }

    /**
     * Getter method for retrieving all Manager employed at the Branch
     * @return arrayList of Manager list
     */
    public ArrayList<Manager> getManagerList() {
        return this.managerList;
    }

    
    /**
     * Getter method for retrieving all Food items offered at the Branch
     * @return arrayList of food items
     */
    public ArrayList<Item> getItemList() {
        return this.itemList;
    }

    
    /**
     * Getter method for retrieving all Orders offered at the Branch
     * @return arrayList of Orders
     */
    public ArrayList<Order> getOrderList() {
        return this.orderList;
    }
    
    
    /**
     * Getter method for retrieving orderID(number of orders made at that branch)
     * @return OrderID as an integer
     */
    public int getOrderId() {
    	return this.orderId;
    }

    
    /**
     * Setter method for changing if a branch is closed or open
     * @param operationStatus Whether the branch is open or closed
     */
    public void setOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
    }

    
    /**
     * Setter method for changing branch's opening hours
     * @param openingHour Opening hour of branch
     */
    public void setOpeningHour(int openingHour) {
        this.openingHour = openingHour;
    }

    
    /**
     * Setter method for changing branch's closing  hours
     * @param closingHour closing hours of branch
     */
    public void setClosingHour(int closingHour) {
        this.closingHour = closingHour;
    }
    
    /**
     * Increases the amount of orders within the Branch
     */
    public void increaseOrderId() {
    	this.orderId++;
    }
 }
