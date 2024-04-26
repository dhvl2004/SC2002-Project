package system;
import java.io.IOException;
import java.util.ArrayList;
import branch.Branch;


/**
 * DataBase class is meant to read and load Staff,Branch and menu list from our Database
 * Database is a csv file containing all records of the afore mentioned classes
 * @author FDAB 2
 * @version 1.0
 */
public class Database {
	
	/**
	 * ArrayList containing all Branches that interacted with Fast-Food Management System
	 */
    static ArrayList<Branch> branchList = new ArrayList<Branch>();
    
    /**
     * ArrayList containing all Accounts that interacted with Fast-Food Management System
     */
    static ArrayList<User> accountList = new ArrayList<User>();

    
    /**
     * <li>Base constructor of DataBase class 
     * <li> Upon instantiation, 2 arrayList are initialized to store data read from the CSV database
     */
    public Database() {

    }
    
    /**
     * <li>This function Reads in Data of branches, menu items and Accounts and loads them into their respective arrayLists within our implementation
     */
    public void loadFiles() {
    	try {
			FileRead.loadBranches("branch_list.csv", branchList);
			FileRead.loadAccounts("staff_list(2).csv", accountList);
			FileRead.loadItems("menu_list(1).csv", branchList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
    }
    
    /**
     * <li> Method facilitates the saving of data from their respective arryLists into our Database CSV file.
     * <li> The Saving of all data alloted during the running of the program occurs only when users exit their specific interface session.
     * <li> Saving of files do not occur if the runtime environment is abruptly terminated.
     */
    public void saveFiles() {
    	try {
			FileWrite.saveBranches("branch_list.csv");
			FileWrite.saveAccounts("staff_list(2).csv");
			FileWrite.saveItems("menu_list(1).csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
    }
    
    
    /**
     * <li>This static class method looks through the arrayList of branchList and returns specific branch specified
     * <li> Returns error if Branch does not exist
     * @param branchName Name/Identifier of the branch
     * @return Returns the Specific Branch Object specified
     * @throws BranchNotFoundException Throws exception message if Branch does not exist/Branch not in the arrayList "Branchlist"
     */
    public static Branch findBranch(String branchName) throws BranchNotFoundException {
    	for (Branch branch : branchList) {
    		if (branch.getBranchName().equals(branchName)) return branch;
    	}
    	throw new BranchNotFoundException("Branch :\"" + branchName + "\" not found");
    }

    /**
     * Getter Method to return branchlist attribute
     * @return arrayList of stored branches in CSV Database
     */
    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    
    /**
     * Getter Method to return accountlist attribute
     * @return arrayList of stored accounts in CSV Database
     */
    public ArrayList<User> getAccountList() {
        return accountList;
    }
}
