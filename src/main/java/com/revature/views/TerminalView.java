package com.revature.views;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;

import java.util.Scanner;

public abstract class TerminalView {
    protected Scanner scanner;

    public TerminalView(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract void displayMenu(UserEntity entity); // need user entity to say if your logged in or not when displaying menu

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void displayIsLoggedIn(UserEntity userEntity){
        if(userEntity.getIsLoggedIn()){
            System.out.println("Currently Logged In As: " + userEntity.getUsername());
            System.out.println("UserId: " + userEntity.getUserId());
        }else {
            System.out.println("Currently Not Logged In");
        }
    }

    public void displayCurrentBalance(BankAccountEntity bankAccountEntity){
        System.out.println("Your Currrent Balance is $" + bankAccountEntity.getBalance());
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
