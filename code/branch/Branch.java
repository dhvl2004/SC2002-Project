package branch;

import java.util.ArrayList;
import item.Item;
import staff.Manager;
import staff.Staff;

public class Branch {
    private int branchId;
    private boolean isOperating = true;
    private int openingHour = 800, closingHour = 2200;
    
    ArrayList<Staff> staffList = new ArrayList<>();
    ArrayList<Manager> managerList = new ArrayList<>();
    ArrayList<Item> itemList = new ArrayList<>();
    ArrayList<Order> orderList = new ArrayList<>();

    public Branch(int branchId) {
        this.branchId = branchId;
    }

    public int getBranchId() {
        return this.branchId;
    }

    public boolean getIsOperating() {
        return this.isOperating;
    }

    public int getOpeningHour() {
        return this.openingHour;
    }

    public int getClosingHour() {
        return this.closingHour;
    }

    public ArrayList<Staff> getStaffList() {
        return this.staffList;
    }

    public ArrayList<Manager> getManagerList() {
        return this.managerList;
    }

    public ArrayList<Item> getItemList() {
        return this.itemList;
    }

    public ArrayList<Order> getOrderList() {
        return this.orderList;
    }

    public boolean shutdown() {
        if (this.isOperating == false) return false;
        this.isOperating = false;
        return true;
    }

    public boolean reopen() {
        if (this.isOperating == true) return false;
        this.isOperating = true;
        return true;
    }
 }
