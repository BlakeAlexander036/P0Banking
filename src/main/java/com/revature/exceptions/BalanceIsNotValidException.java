package com.revature.exceptions;

public class BalanceIsNotValidException extends RuntimeException {
    public BalanceIsNotValidException(String message) {
        super(message);
    }
}
