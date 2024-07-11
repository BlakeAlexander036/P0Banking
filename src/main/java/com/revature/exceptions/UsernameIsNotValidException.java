package com.revature.exceptions;

public class UsernameIsNotValidException extends RuntimeException {
    public UsernameIsNotValidException(String message) {
        super(message);
    }
}
