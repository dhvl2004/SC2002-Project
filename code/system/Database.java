package system;
import java.io.IOException;
import java.util.ArrayList;
import admin.Admin;
import branch.Branch;
import branch.ItemManagement;
import item.Item;
import item.Item.Category;
import staff.Manager;
import staff.Staff;
import system.User.Gender;

public class Database {
    static ArrayList<Branch> branchList = new ArrayList<Branch>();
    static ArrayList<User> accountList = new ArrayList<User>();

    public Database() {
    	try {
			FileIO.loadBranches("branch_list.csv", branchList);
			FileIO.loadAccounts("staff_list(2).csv", accountList);
			FileIO.loadItems("menu_list(1).csv", branchList);
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
