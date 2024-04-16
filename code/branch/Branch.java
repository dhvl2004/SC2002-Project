package branch;

import java.util.ArrayList;
import item.Item;
import order.Order;
import staff.Staff;
import staff.Manager;

public class Branch {
    private String branchName;
    private String branchLocation;

    private int staffQuota;
    private int managerQuota;
    private int[] managerQuotaList = {1, 2, 3};
    private int[] managerQuotaThreshold = {1, 5, 9};

    boolean isOperating = true;
    int openingHour = 800, closingHour = 2200;
    
    ArrayList<Staff> staffList = new ArrayList<>();
    ArrayList<Manager> managerList = new ArrayList<>();
    ArrayList<Item> itemList = new ArrayList<>();
    ArrayList<Order> orderList = new ArrayList<>();

    public Branch(String branchName, String branchLocation, int staffQuota) {
        this.branchName = branchName;
        this.branchLocation = branchLocation;
        this.staffQuota = staffQuota;
        for (int i = 0; i <= managerQuotaThreshold.length; i++) {
            if (this.getStaffQuota() <= managerQuotaThreshold[i]) {
                this.managerQuota = managerQuotaList[i];
                break;
            }
        }
    }

    public String getBranchName() {
        return this.branchName;
    }

    public String getBranchLocation() {
        return this.branchLocation;
    }

    public int getStaffQuota() {
        return this.staffQuota;
    }

    public int getManagerQuota() {
        return this.managerQuota;
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
 }
