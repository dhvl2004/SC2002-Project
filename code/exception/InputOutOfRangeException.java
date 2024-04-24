package exception;

public class InputOutOfRangeException extends Exception {
    public InputOutOfRangeException() {
        super();
    }
    public InputOutOfRangeException(String errorMessage) {
        super(errorMessage);
    }
}
