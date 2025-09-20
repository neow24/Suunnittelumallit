package proxy;

public class AccessDeniedException extends Exception {
    public AccessDeniedException() {
        super("Access denied");
    }
}
