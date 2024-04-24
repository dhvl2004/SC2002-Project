package system;
import java.io.IOException;
import java.util.ArrayList;
import branch.Branch;

public class Database {
    static ArrayList<Branch> branchList = new ArrayList<Branch>();
    static ArrayList<User> accountList = new ArrayList<User>();

    public Database() {

    }
    
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
    
    public static Branch findBranch(String branchName) throws BranchNotFoundException {
    	for (Branch branch : branchList) {
    		if (branch.getBranchName().equals(branchName)) return branch;
    	}
    	throw new BranchNotFoundException("Branch :\"" + branchName + "\" not found");
    }

    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    public ArrayList<User> getAccountList() {
        return accountList;
    }
}
