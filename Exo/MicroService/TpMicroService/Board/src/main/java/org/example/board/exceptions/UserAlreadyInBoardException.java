package org.example.board.exceptions;

public class UserAlreadyInBoardException extends RuntimeException {
    public UserAlreadyInBoardException(String message) {
        super(message);
    }

    public UserAlreadyInBoardException() {
    }
}
