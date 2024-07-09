package com.revature.views;

import java.util.Scanner;

public class UserMenuView extends TerminalView{

    public UserMenuView(Scanner scanner) {
        super(scanner);
    }
    public void displayMenu() {
        System.out.println("=== User Menu ===");
        System.out.println("1. Create Account");
        System.out.println("2. View Accounts");
        System.out.println("3. Logout");
        System.out.print("Select an option: ");
    }
}
