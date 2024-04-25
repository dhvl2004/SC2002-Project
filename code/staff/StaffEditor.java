package staff;

import branch.Branch;
import system.User.Gender;

/**
 * Class that facilitates the editing of staff information, which includes: name,gender,age,etc.
 */
public class StaffEditor {
	
	/**
	 * Staff object to be edited
	 */
    private Staff staff;

    
    /**
     * constructor for Staffeditor
     * <li>Upon object creation, a staff object will be open to editing through this class
     * @param staff staff object to be edited
     */
    public StaffEditor(Staff staff) {
        this.staff = staff;
    }

    
    /**
     * Facilitate changing the staff's branch
     * @param branch New Branch of intended Staff
     * @return <li>Returns True if changing Branches was successful
     * 		   <li>Returns False if branch to be edit is already the branch of the staff, or if staff does not exist
     */
    public boolean editBranch(Branch branch) {
        if (this.staff == null || branch == this.staff.getBranch()) {
            return false;
        }
        
        this.staff.setBranch(branch);
        return true;
    }
    
    
    /**
     * 
     * Facilitate changing the staff's UserID
     * @param userID New UserID of intended Staff
     * @return <li>Returns True if changing UserID was successful
     * 		   <li>Returns False if UserID to be edit is already the UserID of the staff, or if staff does not exist
     */
    public boolean editUserId(String userId) {
        if (this.staff == null || userId == this.staff.getUserId()) {
            return false;
        }
        
        this.staff.setUserId(userId);
        return true;
    }

    
/**
 * Facilitate changing the staff's Name
 * @param name New Name of intended Staff
 * @return <li>Returns True if changing Name was successful
 * 		   <li>Returns False if Name to be edit is already the Name of the staff, or if staff does not exist
 */
    public boolean editName(String name) {
        if (this.staff == null || name == this.staff.getName()) {
            return false;
        }
        
        this.staff.setName(name);
        return true;
    }

    
 
    /**
	 * Facilitate changing the staff's Gender
	 * @param gender New Gender of intended Staff
	 * @return <li>Returns True if changing Gender was successful
	 * 		   <li>Returns False if Gender to be edit is already the Gender of the staff, or if staff does not exist
	 */
    public boolean editGender(Gender gender) {
        if (this.staff == null || gender == this.staff.getGender()) {
            return false;
        }

        this.staff.setGender(gender);
        return true;    
    }

    
    /**
     * 
     * Facilitate changing the staff's Age
	 * @param age New Age of intended Staff
	 * @return <li>Returns True if changing Age was successful
	 * 		   <li>Returns False if Gender to be edit is already the Age of the staff, or if staff does not exist 
     *
     */
    public boolean editAge(int age) {
        if (this.staff == null || age == this.staff.getAge()) {
            return false;
        }

        this.staff.setAge(age);
        return true;    
    }
}
