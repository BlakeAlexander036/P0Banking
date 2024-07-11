package com.revature.exceptions;

public class BankAccountNumberIsNotValidException extends RuntimeException {
    public BankAccountNumberIsNotValidException(String message) {
        super(message);
    }
}
