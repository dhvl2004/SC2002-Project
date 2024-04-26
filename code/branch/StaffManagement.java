package branch;

import staff.Staff;



/**
 * <li>Class allows for manipulation of the Staff in a certain branch
 * <li>Facilitates the movement and or removal of Staff within a certain branch 
 * @author FDAB 2
 * @version 1.0 
 */
public class StaffManagement {
    private Branch branch;

    
    /**
     * **
     * Constructor for the StaffManagement Class
     * @param branch Branch containing the staff to be edited 
     */
    public StaffManagement(Branch branch) {
        this.branch = branch;
    }

    
    /**
     * Looks through the Branch and retrieves the Staff specified
     * @param staffId ID to identify the Staff to be retrieved
     * @return <li>Staff object representing the Staff retrieved
     *         <li>Null if staff does not exist
     */
    public Staff getStaff(String staffId) {
        for (Staff staff : this.branch.staffList) {
            if (staffId.equals(staff.getUserId())) {
                return staff;
            }
        }
        return null;
    }

    
    
    /**
     * <li>If Staff quota is not reached, method allows the addition of a new staff
     * @param staff staff to be added to the branch
     * @return <li>True, if staff does not exceed the limit of a branch, and staff is successfully added
     *         <li>False , if staff quota is reached or if staff already exists in branch
     */
    public boolean addStaff(Staff staff) {
        if (this.branch.staffList.size() == this.branch.getStaffQuota() ||
                this.getStaff(staff.getUserId()) != null) {  
            return false;
        }

        this.branch.staffList.add(staff);
        return true;
    }

    
    /**
     * Method removes the manager from a branch
     * @param staffId Staff to be removed
     * @return <li>Staff object that was removed, if removal was successful
     *         <li>NULL if staff to be removes is not found in the branch
     */
    public Staff removeStaff(String staffId) {
        Staff staff = this.getStaff(staffId);
        if (staff == null) {
            return null;
        }

        this.branch.staffList.remove(staff);
        return staff;
    }
}

