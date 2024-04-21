package staff;
import java.util.ArrayList;

import branch.Branch;
import branch.ItemManagement;
import item.Item;
import item.Item.Category;

public class Manager extends Staff {
    private ItemManagement itemManagement = new ItemManagement(this.branch);

    public Manager(Branch branch, String managerId, String password, String staffName, Gender gender, int age) {
        super(branch, managerId, password, staffName, gender, age);
        this.userType = UserType.MANAGER;
    }

    public void displayStaffList() {
        ArrayList<Staff> staffList = this.branch.getStaffList();
        for (int i = 0; i <= staffList.size(); i++) {
            System.out.println("Staff No." + (i + 1));
            System.out.println("\tStaff Login ID:\t" + staffList.get(i).getUserId());
            System.out.println("\tGender:\t" + staffList.get(i).getGender());
            System.out.println("\tAge:\t" + staffList.get(i).getAge());
        }
    }

    public boolean addItem(String itemId, String itemName, double price, int quantity, Category category, String description) {
        Item item = new Item(itemId, itemName, price, category, description);
        return itemManagement.addItem(item);
    }

    public boolean editItem(String itemId, int newItemId, double newPrice, String newDescription) {
        ///

        ///
        return true;
    }

    public Item removeItem(String itemId) {
        return itemManagement.removeItem(itemId);
    }
}

