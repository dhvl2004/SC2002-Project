package branch;

import staff.Manager;


/**
 * <li>Class allows for manipulation of the Managers in a certain branch
 * <li>Facilitates the movement and or removal of managers within a certain branch 
 * @author FDAB 2
 * @version 1.0 
 */
public class ManagerManagement {
    private Branch branch;

    
    /**
     * Constructor for the ManagerManagement Class
     * @param branch Branch containing the manager to be edited 
     */
    public ManagerManagement(Branch branch) {
        this.branch = branch;
    }

    
    /**
     * Looks through the Branch and retrieves the manager specified
     * @param managerId ID to identify the Manager to be retrieved
     * @return <li>Manager object representing the Manager retrieved
     *         <li>Null if manager does not exist
     */
    public Manager getManager(String managerId) {
        for (Manager manager : this.branch.getManagerList()) {
            if (managerId.equals(manager.getUserId())) {
                return manager;
            }
        }
        return null;
    }

    
    /**
     * <li>If manager quota is not reached, method allows the addition of a new manager
     * @param manager Manager to be added to the branch
     * @return <li>True, if manager does not exceed the limit of a branch, and manager is successfully added
     *         <li>False , if manager quota is reached or if manager already exists in branch
     */
    public boolean addManager(Manager manager) {
        if (this.branch.managerList.size() == this.branch.getManagerQuota() ||
                getManager(manager.getUserId()) != null) {
//            System.out.println("Cannot add manager. Manager quota reached or manager already exists.");
            return false;
        }

        this.branch.managerList.add(manager);
//        System.out.println("Manager added: " + manager.getName());
        return true;
    }

    
    /**
     * Method removes the manager from a branch
     * @param managerId Manager to be removed
     * @return <li>Manager object that was removed, if removal was successful
     *         <li>NULL if manager to be removes is not found in the branch
     */
    public Manager removeManager(String managerId) {
        Manager manager = getManager(managerId);
        if (manager == null) {
//            System.out.println("Manager with ID " + managerId + " not found.");
            return null;
        }

        this.branch.managerList.remove(manager);
//        System.out.println("Manager removed: " + manager.getName());
        return manager;
    }
}
