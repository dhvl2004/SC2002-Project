package staff;
import java.util.ArrayList;

import branch.Branch;
import branch.ItemManagement;
import item.Item;

public class Manager extends Staff {
    private ItemManagement itemManagement = new ItemManagement(this.branch);

    public Manager(Branch branch, String staffId, String staffName, Gender gender, int age) {
        super(branch, staffId, staffName, gender, age);
    }

    public void displayStaffList() {
        ArrayList<Staff> staffList = this.branch.getStaffList();
        for (int i = 0; i <= staffList.size(); i++) {
            System.out.println("Staff No." + (i + 1));
            System.out.println("\tStaff ID:\t" + staffList.get(i).getId());
            System.out.println("\tGender:\t" + staffList.get(i).getGender());
            System.out.println("\tAge:\t" + staffList.get(i).getAge());
        }
    }

    public boolean addItem(String itemId, double price, int quantity, String description) {
        Item item = new Item(itemId, price, quantity, description);
        return itemManagement.add(item);
    }

    public boolean editItem(String itemId, int newItemId, double newPrice, int newQuantity, String newDescription) {
        ///

        ///
        return true;
    }

    public Item removeItem(String itemId) {
        return itemManagement.remove(itemId);
    }
}

