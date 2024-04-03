package branch;

import staff.Manager;
import staff.Staff;

public class StaffManagement {
    private Branch branch;
    private int managerNum = 0;
    private int[] managerNumThreshold = {1, 5, 9};

    public StaffManagement(Branch branch) {
        this.branch = branch;
    }

    public Staff findStaff(int staffId) {
        for (int i = 0; i < this.branch.staffList.size(); i++) {
            if (staffId == this.branch.staffList.get(i).getStaffId()) return this.branch.staffList.get(i);
        }
        return null;
    }

    public Manager findManager(int staffId) {
        for (int i = 0; i < this.branch.managerList.size(); i++) {
            if (staffId == this.branch.managerList.get(i).getStaffId()) return this.branch.managerList.get(i);
        }
        return null;
    }

    public boolean addStaff(Staff newStaff) {
        if (findStaff(newStaff.getStaffId()) != null) return false;

        this.branch.staffList.add(newStaff);

        for (int i = 0; i < this.managerNumThreshold.length; i++) {
            if (this.branch.staffList.size() == this.managerNumThreshold[i]) {
                this.managerNum++;
                break;
            }
        }
        return true;
    }

    public boolean addStaff(int staffId, boolean isMale, int age) {
        if (findStaff(staffId) != null) return false;

        Staff newStaff = new Staff(this.branch, staffId, isMale, age);
        this.branch.staffList.add(newStaff);

        for (int i = 0; i < this.managerNumThreshold.length; i++) {
            if (this.branch.staffList.size() == this.managerNumThreshold[i]) {
                this.managerNum++;
                break;
            }
        }
        return true;
    }

    public boolean editStaff(int staffId, int newStaffId, boolean newIsMale, int newAge) {
        Staff staff = findStaff(staffId);
        if (staff == null) return false;
        ///

        ///
        return true;
    }

    public Staff removeStaff(int staffId) {
        Staff staff = findStaff(staffId);
        if (staff == null) return null;

        this.branch.staffList.remove(staff);
        for (int i = 0; i < this.managerNumThreshold.length; i++) {
            if (this.branch.staffList.size() == this.managerNumThreshold[i]) {
                this.managerNum--;
                break;
            }
        }
        return staff;
    }

    public boolean assignManager(Manager newManager) {
        if (this.branch.managerList.size() == this.managerNum || findManager(newManager.getStaffId()) != null) return false;

        this.branch.managerList.add(newManager);
        return true;
    }

    public boolean promoteStaff(int staffId) {
        Staff staff = this.findStaff(staffId);
        if (this.branch.managerList.size() == managerNum || staff == null) return false;

        Manager newManager = new Manager(this.branch, staffId, staff.getIsMale(), staff.getAge());
        this.branch.managerList.add(newManager);
        this.removeStaff(staffId);
        return true;
    }
}
