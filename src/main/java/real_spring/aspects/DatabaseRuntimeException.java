package real_spring.aspects;

public class DatabaseRuntimeException extends RuntimeException {
    public DatabaseRuntimeException(String message) {
        super(message);
    }
}
