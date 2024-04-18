package system;

import branch.Branch;

public class BranchManagement {
    private Database database;

    public BranchManagement(Database database) {
        this.database = database;
    }

    public Branch find(String branchName) {
        for (Branch branch : this.database.branchList) {
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

        this.database.branchList.add(branch);
        return true;
    }

    public Branch remove(String branchName) {
        Branch branch = this.find(branchName);
        if (branch == null) {
            return null;
        }

        this.database.branchList.remove(branch);
        return branch;
    }
}
