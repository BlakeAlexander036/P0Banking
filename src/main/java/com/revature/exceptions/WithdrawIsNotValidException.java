package com.revature.exceptions;

public class WithdrawIsNotValidException extends RuntimeException {
    public WithdrawIsNotValidException(String message) {
        super(message);
    }
}
