package branch;

import staff.Staff;

public class StaffManagement {
    private Branch branch;

    public StaffManagement(Branch branch) {
        this.branch = branch;
    }

    public Staff getStaff(String staffId) {
        for (Staff staff : this.branch.staffList) {
            if (staffId.equals(staff.getUserId())) {
                return staff;
            }
        }
        return null;
    }

    public boolean addStaff(Staff staff) {
        if (this.branch.staffList.size() == this.branch.getStaffQuota() ||
                this.getStaff(staff.getUserId()) != null) {  
            return false;
        }

        this.branch.staffList.add(staff);
        return true;
    }

    public Staff removeStaff(String staffId) {
        Staff staff = this.getStaff(staffId);
        if (staff == null) {
            return null;
        }

        this.branch.staffList.remove(staff);
        return staff;
    }
}

