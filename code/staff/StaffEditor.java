package staff;

import branch.Branch;
import system.User.Gender;

public class StaffEditor {
    private Staff staff;

    public StaffEditor(Staff staff) {
        this.staff = staff;
    }

    public boolean editBranch(Branch branch) {
        if (this.staff == null || branch == this.staff.getBranch()) {
            return false;
        }
        
        this.staff.setBranch(branch);
        return true;
    }
    
    public boolean editUserId(String userId) {
        if (this.staff == null || userId == this.staff.getUserId()) {
            return false;
        }
        
        this.staff.setUserId(userId);
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
