package org.example.task.exception;

public class UserIsNotInBoardException extends RuntimeException {
    public UserIsNotInBoardException() {
    }

    public UserIsNotInBoardException(String message) {
        super(message);
    }
}
