package com.revature.exceptions;

public class PasswordIsNotValidException extends RuntimeException {
    public PasswordIsNotValidException(String message) {
        super(message);
    }
}
