package branch;

import staff.Staff;

public class StaffManagement {
    private Branch branch;

    public StaffManagement(Branch branch) {
        this.branch = branch;
    }

    public Staff find(String staffId) {
        for (Staff staff : this.branch.staffList) {
            if (staffId.equals(staff.getId())) {
                return staff;
            }
        }
        return null;
    }

    public boolean add(Staff staff) {
        if (this.branch.staffList.size() == this.branch.getStaffQuota() ||
        this.find(staff.getId()) != null) {
            return false;
        }

        this.branch.staffList.add(staff);
        return true;
    }

    public Staff remove(String staffId) {
        Staff staff = this.find(staffId);
        if (staff == null) {
            return null;
        }

        this.branch.staffList.remove(staff);
        return staff;
    }
}

