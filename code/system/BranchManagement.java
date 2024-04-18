package system;

import java.util.ArrayList;

import branch.Branch;

public class BranchManagement {
    private ArrayList<Branch> branchList;

    public BranchManagement(ArrayList<Branch> branchList) {
        this.branchList = branchList;
    }

    public Branch find(String branchName) {
        for (Branch branch : this.branchList) {
            if (branchName.equals(branch.getBranchName())) {
                return branch;
            }
        }
        return null;
    }

    public boolean add(Branch branch) {
        if (this.find(branch.getBranchName()) != null) {
            return false;
        }

        this.branchList.add(branch);
        return true;
    }

    public Branch remove(String branchName) {
        Branch branch = this.find(branchName);
        if (branch == null) {
            return null;
        }

        this.branchList.remove(branch);
        return branch;
    }
}
