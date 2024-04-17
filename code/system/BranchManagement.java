package system;

import branch.Branch;

public class BranchManagement {
    private Database database;

    public BranchManagement(Database database) {
        this.database = database;
    }

    public Branch find(String branchName) {
        Branch branch = null;
        for (int i = 0; i < this.database.branchList.size(); i++) {
            if (branchName == this.database.branchList.get(i).getBranchName()) {
                branch = this.database.branchList.get(i);
                break;
            }
        }
        return branch;
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
