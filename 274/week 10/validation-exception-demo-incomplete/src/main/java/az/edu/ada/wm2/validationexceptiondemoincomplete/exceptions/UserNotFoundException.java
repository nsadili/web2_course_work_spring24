package az.edu.ada.wm2.validationexceptiondemoincomplete.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
