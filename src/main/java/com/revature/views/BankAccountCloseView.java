package com.revature.views;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;

import java.util.Scanner;

public class BankAccountCloseView extends TerminalView {

    public BankAccountCloseView(Scanner scanner) {
        super(scanner);
    }

    public void displayMenu(UserEntity userEntity, BankAccountEntity bankAccountEntity) {
        super.displayIsLoggedIn(userEntity);
        super.displayCurrentBankAccount(bankAccountEntity);
        System.out.println("=== Close Menu ===");
        System.out.println("Are you sure you want to close this account?");
        System.out.print("(y/n): ");
    }

}