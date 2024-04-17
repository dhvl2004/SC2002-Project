package staff;

import branch.*;
import staff.Staff.Gender;

public class StaffEditor {
    private Staff staff;

    public StaffEditor(Branch branch, String loginId) {
        StaffManagement staffManagement = new StaffManagement(branch);
        this.staff = staffManagement.find(loginId);
    }
    
    public boolean editId(String loginId) {
        if (this.staff == null || loginId == this.staff.getId()) {
            return false;
        }
        
        this.staff.setId(loginId);
        return true;
    }

    public boolean editName(String name) {
        if (this.staff == null || name == this.staff.getName()) {
            return false;
        }
        
        this.staff.setName(name);
        return true;
    }

    public boolean editGender(Gender gender) {
        if (this.staff == null || gender == this.staff.getGender()) {
            return false;
        }

        this.staff.setGender(gender);
        return true;    
    }

    public boolean editAge(int age) {
        if (this.staff == null || age == this.staff.getAge()) {
            return false;
        }

        this.staff.setAge(age);
        return true;    
    }
}
