package codes.pnk.model.domain.common;

public class ImageException extends Exception {
    public ImageException() {
        super();
    }

    public ImageException(String message) {
        super(message);
    }
    public ImageException(Throwable cause) {
        super(cause);
    }

    public ImageException(String message, Throwable cause) {
        super(message, cause);
    }
}
