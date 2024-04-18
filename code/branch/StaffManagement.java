package branch;

import staff.Staff;

public class StaffManagement {
    private Branch branch;

    public StaffManagement(Branch branch) {
        this.branch = branch;
    }

    public Staff getStaff(String staffId) {
        for (Staff staff : this.branch.staffList) {
            if (staffId.equals(staff.getId())) {
                return staff;
            }
        }
        return null;
    }

    public boolean addStaff(Staff staff) {
        if (this.branch.staffList.size() == this.branch.getStaffQuota() ||
                this.getStaff(staff.getId()) != null) {
            System.out.println("Cannot add staff. Staff quota reached or staff already exists.");   
            return false;
        }

        this.branch.staffList.add(staff);
        System.out.println("Staff added: " + staff.getName());
        return true;
    }

    public Staff removeStaff(String staffId) {
        Staff staff = this.getStaff(staffId);
        if (staff == null) {
            System.out.println("Staff with ID " + staffId + " not found.");
            return null;
        }

        this.branch.staffList.remove(staff);
        System.out.println("Staff removed: " + staff.getName());
        return staff;
    }
}

