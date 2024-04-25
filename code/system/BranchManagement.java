package system;

import branch.Branch;


/**
 * Class that interacts with the CSV DataBase by facilitating reading,writing and  
 *  @author FDAB 2
 * @version 1.0
 */
public class BranchManagement {
	/**
	 * <li>The DataBase that represents information stored on the CSV DataBase
	 * <li> The DataBase will be read from and written to 
	 */
    private Database database;

    
    /**
     * Constructor that creates an object used to read, write and edit information in input Database
     * @param database DataBase representing information stored into the CSV Database
     */
    public BranchManagement(Database database) {
        this.database = database;
    }

    
    /**
     * <li>Searches through the Database and Retrieves specific branch.
     * <li> Returns NUll if the Branch is not found within the DataBase
     * @param branchName String representing the name of the Branch to be retrieved
     * @return Branch object of requested branch
     */
    public Branch getBranch(String branchName) {
        for (Branch branch : this.database.branchList) {
            if (branchName.equals(branch.getBranchName())) {
                return branch;
            }
        }
        return null;
    }

    
    /**
     * Adds input Branch object into the DataBase
     * @param branch Branch object to be written/stored into the DataBase
     * @return <li> Returns true if adding branch into DataBase was Successful
     *         <li> Returns False if Branch to be added already exists, hence nothing will be added into DataBase
     */
    public boolean addBranch(Branch branch) {
        if (this.getBranch(branch.getBranchName()) != null) {
            return false;
        }

        this.database.branchList.add(branch);
        return true;
    }

    
    /**
     * Searches DataBase for requested Branch, removes the Branch from DataBase and returns removed Branch 
     * @param branchName String Name of the Branch to be removed
     * @return <li>Returns Removed Branch object if removal from DataBase was successful
     *         <li>Returns False if Branch to be remove does not exist within DataBase, hence no removal is made.
     */
    public Branch removeBranch(String branchName) {
        Branch branch = this.getBranch(branchName);
        if (branch == null) {
            return null;
        }

        this.database.branchList.remove(branch);
        return branch;
    }
}
