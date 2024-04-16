package branch;

public class OperationSetting {
    private Branch branch;

    public OperationSetting(Branch branch) {
        this.branch = branch;
    }

    public boolean shutdown() {
        if (this.branch.isOperating == false) {
            return false;
        }

        this.branch.isOperating = false;
        return true;
    }

    public boolean reopen() {
        if (this.branch.isOperating == true) {
            return false;
        }

        this.branch.isOperating = true;
        return true;
    }
}