package org.example.board.exceptions;

public class BoardFullException extends RuntimeException {
    public BoardFullException(String message) {
        super(message);
    }
}
