package system;
import java.util.ArrayList;

import branch.Branch;

public class Database {
    ArrayList<Branch> branchList = new ArrayList<>();
    ArrayList<User> accountList = new ArrayList<>();

    public ArrayList<Branch> getBranchList() {
        return this.branchList;
    }

    public ArrayList<User> getAccountList() {
        return this.accountList;
    }
}
