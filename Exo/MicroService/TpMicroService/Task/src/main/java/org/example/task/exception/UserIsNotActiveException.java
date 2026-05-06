package org.example.task.exception;

public class UserIsNotActiveException extends RuntimeException {
    public UserIsNotActiveException() {
    }

    public UserIsNotActiveException(String message) {
        super(message);
    }
}
