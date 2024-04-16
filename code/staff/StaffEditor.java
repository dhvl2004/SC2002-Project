package staff;

import branch.*;
import staff.Staff.Gender;

public class StaffEditor {
    private Staff staff;

    public StaffEditor(Branch branch, String staffId) {
        StaffManagement staffManagement = new StaffManagement(branch);
        this.staff = staffManagement.find(staffId);
    }
    
    public boolean editStaffId(String newStaffId) {
        if (this.staff == null || newStaffId == this.staff.getStaffId()) {
            return false;
        }
        
        this.staff.setStaffId(newStaffId);
        return true;
    }

    public boolean editStaffName(String newStaffName) {
        if (this.staff == null || newStaffName == this.staff.getStaffName()) {
            return false;
        }
        
        this.staff.setStaffName(newStaffName);
        return true;
    }

    public boolean editStaffGender(Gender newGender) {
        if (this.staff == null || newGender == this.staff.getGender()) {
            return false;
        }

        this.staff.setGender(newGender);
        return true;    
    }

    public boolean editStaffAge(int newAge) {
        if (this.staff == null || newAge == this.staff.getAge()) {
            return false;
        }

        this.staff.setAge(newAge);
        return true;    
    }
}
