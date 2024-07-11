package com.revature.utilities;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;
import com.revature.exceptions.*;

import java.util.List;

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
            double balanceDouble = Double.parseDouble(balance);
            if (balanceDouble < 0) {throw new BalanceIsNotValidException("input must be positive");}
            return true;
        } catch (NumberFormatException e) {
            throw new BalanceIsNotValidException("Balance must be inputted as a decimal or integer number");
        }


    }

    public static boolean isValidWithdraw(String withdrawAmount, double balance) throws WithdrawIsNotValidException {
        try {
            isValidBalance(withdrawAmount);
            if(balance - Double.parseDouble(withdrawAmount) < 0){
                throw new WithdrawIsNotValidException("Balance must be 0 or above, cannot withdraw to a negative balance");
            }
            return true;
        } catch (BalanceIsNotValidException exception){
            System.out.println(exception.getMessage());
        }
        return false;

    }

    public static boolean isValidBankAccountNumberAnInt(String bankAccountNumber) throws BankAccountNumberIsNotValidException{
        if (bankAccountNumber == null || bankAccountNumber.isEmpty()) {
            throw new BankAccountNumberIsNotValidException("Bank Account Number must be inputted as an integer");
        }
        try {
            Integer.parseInt(bankAccountNumber);
            return true;
        } catch (NumberFormatException e) {
            throw new BankAccountNumberIsNotValidException("Bank Account Number must be inputted as an integer");
        }
    }

    public static boolean isValidBankAccountNumberInEntityList(String bankAccountNumber, List<BankAccountEntity> bankAccountEntityList) throws BankAccountNumberIsNotValidException{

        if (isValidBankAccountNumberAnInt(bankAccountNumber)){
            for (BankAccountEntity bankAccountEntity : bankAccountEntityList){
                if (bankAccountEntity.getAccountNumber() == Integer.parseInt(bankAccountNumber)){
                  return true;
                }
            }
            throw new BankAccountNumberIsNotValidException("Bank Account Number does not exist, enter a valid Bank Account Number.");
        }
        return false;
    }

    public static boolean isValidPasswordAndUsernameLoginUserInDB(UserEntity userEntity) throws UsernameAndPasswordDoesNotExistException{
        if(!userEntity.getIsLoggedIn()){ throw new UsernameAndPasswordDoesNotExistException("User with Username and Password does not exist, re-enter Username and Password"); }
        return true;
    }

    public static boolean isRegistered(UserEntity userEntity) {
        if(!userEntity.getIsLoggedIn()){ throw new UsernameAlreadyExistsException("User with Username '" + userEntity.getUsername() + "' already exists, please enter a different Username."); }
        return true;
    }



}
