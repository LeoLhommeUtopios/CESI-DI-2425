package org.example.usermicservice.exceptions;

public class UserAlreadyHaveMaxTaskException extends RuntimeException {
    public UserAlreadyHaveMaxTaskException(String message) {
        super(message);
    }
}
