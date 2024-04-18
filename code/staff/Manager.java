package staff;
import java.util.ArrayList;

import branch.Branch;
import branch.ItemManagement;
import item.Item;

public class Manager extends Staff {
    private ItemManagement itemManagement = new ItemManagement(this.branch);

    public Manager(Branch branch, String loginId, String staffName, Gender gender, int age) {
        super(branch, loginId, staffName, gender, age);
    }

    public void displayStaffList() {
        ArrayList<Staff> staffList = this.branch.getStaffList();
        for (int i = 0; i <= staffList.size(); i++) {
            System.out.println("Staff No." + (i + 1));
            System.out.println("\tStaff Login ID:\t" + staffList.get(i).getId());
            System.out.println("\tGender:\t" + staffList.get(i).getGender());
            System.out.println("\tAge:\t" + staffList.get(i).getAge());
        }
    }

    public boolean addItem(String itemId, String itemName, double price, int quantity, String category) {
        Item item = new Item(itemId, itemName, price, category);
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

