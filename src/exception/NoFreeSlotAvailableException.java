package exception;

public class NoFreeSlotAvailableException extends RuntimeException {
    public NoFreeSlotAvailableException(String message) {
        super(message);
    }
}
