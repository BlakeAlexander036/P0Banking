package com.revature.views;

import com.revature.entities.UserEntity;

import java.util.Scanner;

public class BankAccountCloseView extends TerminalView {

    public BankAccountCloseView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void displayMenu(UserEntity userEntity) {
        super.displayIsLoggedIn(userEntity);
        //super.displayCurrentBalance(bankAccountEntity);
        //System.out.println("Your Currrent Balance is $" + displayBalance());
        System.out.println("=== Close Menu ===");
        System.out.println("Are you sure you want to close this account?");
        System.out.print("(y/n): ");
    }

}