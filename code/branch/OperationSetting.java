package branch;

import branch.Branch.OperationStatus;

public class OperationSetting {
    private Branch branch;

    public OperationSetting(Branch branch) {
        this.branch = branch;
    }

    public boolean close() {
        if (this.branch.getOperationStatus() != OperationStatus.OPEN) {
            return false;
        }

        this.branch.setOperationStatus(OperationStatus.CLOSE);
        return true;
    }

    public boolean open() {
        if (this.branch.getOperationStatus() != OperationStatus.CLOSE) {
            return false;
        }

        this.branch.setOperationStatus(OperationStatus.OPEN);
        return true;
    }
}