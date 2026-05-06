package org.example.task.exception;

public class TaskNotInProgressStateException extends RuntimeException {
    public TaskNotInProgressStateException() {
    }

    public TaskNotInProgressStateException(String message) {
        super(message);
    }
}
