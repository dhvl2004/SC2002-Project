package exception;


/**
 * Exception class that gets thrown if input is out of range 
 * @author FDAB 2
 * @version 1.0
 */
public class InputOutOfRangeException extends Exception {
	
	/**
	 * Base constructor for Class, calls the base-clss exception
	 */
    public InputOutOfRangeException() {
        super();
    }
    
    /**
     * Constructor for this exception class, prints input-specified error message 
     * @param errorMessage Error message to be shown when exception gets thrown
     */
    public InputOutOfRangeException(String errorMessage) {
        super(errorMessage);
    }
}
