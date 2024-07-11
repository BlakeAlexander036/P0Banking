package com.revature.exceptions;

public class UsernameAndPasswordDoesNotExistException extends RuntimeException {
    public UsernameAndPasswordDoesNotExistException (String message){
        super(message);
    }
}
