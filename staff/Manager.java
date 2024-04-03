package staff;
import java.util.ArrayList;

import branch.Branch;
import branch.ItemManagement;
import item.Item;

public class Manager extends Staff {
    private ItemManagement itemManagement = new ItemManagement(this.branch);

    public Manager(Branch branch, int staffId, boolean isMale, int age) {
        super(branch, staffId, isMale, age);
    }

    public void displayStaffList() {
        ArrayList<Staff> staffList = this.branch.getStaffList();
        for (int i = 0; i <= staffList.size(); i++) {
            System.out.println("Staff No." + (i + 1));
            System.out.println("\tStaff ID:\t" + staffList.get(i).getStaffId());
            String gender = "Female";
            if (staffList.get(i).getIsMale()) gender = "Male";
            System.out.println("\tGender:\t" + gender);
            System.out.println("\tAge:\t" + staffList.get(i).getAge());
        }
    }

    public boolean addItem(int itemId, double price, int quantity, String description) {
        return itemManagement.addItem(itemId, price, quantity, description);
    }

    public boolean editItem(int itemId, int newItemId, double newPrice, int newQuantity, String newDescription) {
        return itemManagement.editItem(itemId, newItemId, newPrice, newQuantity, newDescription);
    }

    public Item removeItem(int itemId) {
        return itemManagement.removeItem(itemId);
    }
}
