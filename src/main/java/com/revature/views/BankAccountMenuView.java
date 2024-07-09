package com.revature.views;

import java.util.Scanner;

public class BankAccountMenuView extends TerminalView {

    public BankAccountMenuView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void displayMenu() {
        System.out.println("=== Account Menu ===");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. View Account Details");
        System.out.println("4. Back to User Menu");
        System.out.print("Select an option: ");
    }

}
