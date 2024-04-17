package branch;

import staff.Staff;

public class StaffManagement {
    private Branch branch;

    public StaffManagement(Branch branch) {
        this.branch = branch;
    }

    public Staff find(String staffId) {
        Staff staff = null;
        for (int i = 0; i < this.branch.staffList.size(); i++) {
            if (staffId == this.branch.staffList.get(i).getId()) {
                staff =  this.branch.staffList.get(i);
                break;
            }
        }
        return staff;
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

