package system;

/**
 * Class that throws exception when a branch is not located
 */
public class BranchNotFoundException extends Exception {
	
	/**
	 * Base constructor with default message displayed when Branch is not found
	 *  @author FDAB 2
	 * @version 1.0
	 */
	public BranchNotFoundException() {
		super("Branch not found");
	}
	
	/**
	 * Constructor that prints input text when Branch is not found
	 * @param message Intended message to be seen when exception is thrown
	 */
	public BranchNotFoundException(String message) {
		super(message);
	}
}
	