package branch;

import java.util.ArrayList;
import item.Item;
import order.Order;
import staff.Staff;
import staff.Manager;

public class Branch {
    public enum OperationStatus {OPEN, CLOSE};

    private String branchName;
    private String branchLocation;

    private int staffQuota;
    private int managerQuota = 0;
    private int[] managerQuotaList = {1, 2, 3};
    private int[] managerQuotaThreshold = {1, 5, 9};

    private OperationStatus operationStatus = OperationStatus.OPEN;
    private int openingHour = 800, closingHour = 2200;
    
    ArrayList<Staff> staffList = new ArrayList<Staff>();
    ArrayList<Manager> managerList = new ArrayList<Manager>();
    ArrayList<Item> itemList = new ArrayList<Item>();
    ArrayList<Order> orderList = new ArrayList<Order>();

    public Branch(String branchName, String branchLocation, int staffQuota) {
        this.branchName = branchName;
        this.branchLocation = branchLocation;
        this.staffQuota = staffQuota;
        for (int i = 0; i < this.managerQuotaThreshold.length; i++) {
            if (this.getStaffQuota() <= this.managerQuotaThreshold[i]) {
                this.managerQuota = this.managerQuotaList[i];
                break;
            }
        }
        if (this.managerQuota == 0) {
            this.managerQuota = this.managerQuotaList[this.managerQuotaList.length - 1];
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

    public OperationStatus getOperationStatus() {
        return this.operationStatus;
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

    public void setOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
    }

    public void setOpeningHour(int openingHour) {
        this.openingHour = openingHour;
    }

    public void setClosingHour(int closingHour) {
        this.closingHour = closingHour;
    }
 }
