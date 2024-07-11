package com.revature.views;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;

import java.util.Scanner;

public class BankAccountMenuView extends TerminalView {

    public BankAccountMenuView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void displayMenu(UserEntity userEntity) {
        super.displayIsLoggedIn(userEntity);
        //super.displayCurrentBalance(bankAccountEntity);
        System.out.println("=== Account Menu ===");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("4. Back to User Menu");
        System.out.print("Select an option: ");
    }


}
