package system;

public class BranchNotFoundException extends Exception {
	public BranchNotFoundException() {
		super("Branch not found");
	}
	
	public BranchNotFoundException(String message) {
		super(message);
	}
}
	