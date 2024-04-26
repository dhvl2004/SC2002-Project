package branch;

import branch.Branch.OperationStatus;


/**
 * Class that facilitates the changes in operation status of the branch
 * @author FDAB 2
 * @version 1.0 
 * 
 */
public class OperationStatusEditor {
    private Branch branch;

    
    /**
     * Base constructor 
     * @param branch Branch whose operation status is intended for change
     */
    public OperationStatusEditor(Branch branch) {
        this.branch = branch;
    }

    
    /**
     * Changes the operating status of the function from open to close
     * @return <li>True if operation switch was successful
     * <li>False if branch is already closed
     */        
    public boolean close() {
        if (this.branch.getOperationStatus() != OperationStatus.OPEN) {
            return false;
        }

        this.branch.setOperationStatus(OperationStatus.CLOSE);
        return true;
    }

    
    /**
     *  Changes the operating status of the function from close to open
     *  
     * @return <li>True if operation switch was successful
     * <li>False if branch is already open
     * 
     * 
     */
    public boolean open() {
        if (this.branch.getOperationStatus() != OperationStatus.CLOSE) {
            return false;
        }

        this.branch.setOperationStatus(OperationStatus.OPEN);
        return true;
    }
}