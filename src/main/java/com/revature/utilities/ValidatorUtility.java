package com.revature.utilities;

import com.revature.exceptions.PasswordIsNotValidException;
import com.revature.exceptions.UsernameIsNotValidException;

public class ValidatorUtility {
    // Methods for input validation
    public static boolean isValidUsername(String username) throws UsernameIsNotValidException {
        if (username.length() > 30){
            return false;
        }

        return true; // come back to this
    }
    public static boolean isValidPassword(String password) throws PasswordIsNotValidException {
        if (password.length() > 30){
            return false;
        }
        return true; // come back to this
    }


}
