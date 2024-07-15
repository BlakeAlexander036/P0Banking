package com.revature.views;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;

import java.util.List;
import java.util.Scanner;

public class BankAccountMenuView extends TerminalView {

    public BankAccountMenuView(Scanner scanner) {
        super(scanner);
    }


    public void displayMenu(UserEntity userEntity, BankAccountEntity bankAccountEntity) {
        super.displayIsLoggedIn(userEntity);
        super.displayCurrentBankAccount(bankAccountEntity);
        System.out.println("=== Bank Account Menu ===");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Close Account");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }


}