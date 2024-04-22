package exception;

public class InputOutOfRange extends Exception {
    public InputOutOfRange() {
        super();
    }
    public InputOutOfRange(String errorMessage) {
        super(errorMessage);
    }
}
