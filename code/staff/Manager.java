package staff;
import java.util.ArrayList;

import branch.Branch;
import branch.ItemManagement;
import item.Item;
import item.Item.Category;


/**
 * <li>CLass extends from staff class, specialization as Manager Class
 * <li> Has all the capabilities of Staff, but can also add,remove and edit food items in a branch
 * @author FDAB 2
 * @version 1.0
 */
public class Manager extends Staff {
	
	/**
	 * Item management class used for editing and storing food items 
	 */
    private ItemManagement itemManagement = new ItemManagement(this.branch);

    
    /**
     * public constructor of the Manager class that instantiates all the info of a Manager
     * @param branch Branch the Manager is located at
     * @param managerId ID that represents the specific Manager
     * @param password Manager's password
     * @param staffName name of the manager
     * @param gender Gender of the manager
     * @param age Age of the Manager
     */
    public Manager(Branch branch, String managerId, String password, String staffName, Gender gender, int age) {
        super(branch, managerId, password, staffName, gender, age);
        this.userType = UserType.MANAGER;
    }

    
    /**
     * <li>Method allows the manager to display all the staff currently working at Branch that the  Manager is in-charge of
     */
    public void displayStaffList() {
        ArrayList<Staff> staffList = this.branch.getStaffList();
        for (int i = 0; i <= staffList.size(); i++) {
            System.out.println("Staff No." + (i + 1));
            System.out.println("\tStaff Login ID:\t" + staffList.get(i).getUserId());
            System.out.println("\tGender:\t" + staffList.get(i).getGender());
            System.out.println("\tAge:\t" + staffList.get(i).getAge());
        }
    }

    
    /**
     * Adds new food item to the current Item Management UI session
     * @param itemId ID of the food item
     * @param itemName Name  of the food item
     * @param price Price of the food item
     * @param quantity Quantity of the food item
     * @param category Category of the food item
     * @param description Description of the food item
     * @return Returns True if the item is added successfully
     */
    public boolean addItem(String itemId, String itemName, double price, int quantity, Category category, String description) {
        Item item = new Item(itemId, itemName, price, category, description);
        return itemManagement.addItem(item);
    }

    
    /**
     * Facilitates the editing of food items on the current Item Management UI Session
     * @param itemId item ID of current food item to be changed
     * @param newItemId New item ID of the food item to be changed
     * @param newPrice New price ID of the food item to be changed
     * @param newDescription New Description ID of the food item to be changed
     * @return Returns true upon successful editing of food item, else returns false
     */
    public boolean editItem(String itemId, int newItemId, double newPrice, String newDescription) {
        ///

        ///
        return true;
    }

    
    /**
     * Facilitates the removal of food item in current UI session displaying customers foods items
     * @param itemId ID of food item to be removed
     * @return Returns true if removal of Food item was successful, else returns false
     */
    public Item removeItem(String itemId) {
        return itemManagement.removeItem(itemId);
    }
}

