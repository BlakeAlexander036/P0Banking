package com.revature.utilities;

import com.revature.exceptions.BalanceIsNotValidException;
import com.revature.exceptions.PasswordIsNotValidException;
import com.revature.exceptions.UsernameIsNotValidException;

public class ValidatorUtility {
    // Methods for input validation
    public static boolean isValidUsername(String username) throws UsernameIsNotValidException {
        if (username.length() > 30){
            throw new UsernameIsNotValidException("Username needs to be less than or equal to 30 characters. ");
        }

        return true; // come back to this
    }
    public static boolean isValidPassword(String password) throws PasswordIsNotValidException {
        if (password.length() > 30){
            throw new PasswordIsNotValidException("Password needs to be less than or equal to 30 characters. ");
        }
        return true; // come back to this
    }

    public static boolean isValidBalance(String balance) throws BalanceIsNotValidException {
        if (balance == null || balance.isEmpty()) {
            throw new BalanceIsNotValidException("Balance must be inputted as a decimal or integer number");
        }
        try {
            Double.parseDouble(balance);
            return true;
        } catch (NumberFormatException e) {
            throw new BalanceIsNotValidException("Balance must be inputted as a decimal or integer number");
        }
    }


}
