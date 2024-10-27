package codes.pnk.model.domain.exception;

public class AlgorithmException extends Exception {
    public AlgorithmException() {
        super();
    }

    public AlgorithmException(String message) {
        super(message);
    }
    public AlgorithmException(Throwable cause) {
        super(cause);
    }

    public AlgorithmException(String message, Throwable cause) {
        super(message, cause);
    }
}
