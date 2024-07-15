package com.revature.views;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;

import java.util.List;
import java.util.Scanner;

public abstract class TerminalView {
    protected Scanner scanner;

    public TerminalView(Scanner scanner) {
        this.scanner = scanner;
    }


    public void whiteSpace(){
        System.out.println("\n\n\n\n\n");
    }
    public String getUserInput() {
        String input = scanner.nextLine();
        whiteSpace();
        return input;
    }

    public void displayIsLoggedIn(UserEntity userEntity){
        if(userEntity.getIsLoggedIn()){
            System.out.println("Currently Logged In As: " + userEntity.getUsername());
            System.out.println("UserId: " + userEntity.getUserId());
        }else {
            System.out.println("Currently Not Logged In");
        }
    }

    public void displayCurrentBankAccount(BankAccountEntity bankAccountEntity){
        System.out.println("Currrent Bank Account Number: " + bankAccountEntity.getAccountNumber());
        System.out.println("Currrent Balance: $" + String.format("%.2f", bankAccountEntity.getBalance()));
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
