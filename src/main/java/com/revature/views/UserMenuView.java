package com.revature.views;

import com.revature.entities.UserEntity;

import java.util.Scanner;

public class UserMenuView extends TerminalView{

    public UserMenuView(Scanner scanner) {
        super(scanner);
    }
    public void displayMenu(UserEntity userEntity) {
        super.displayIsLoggedIn(userEntity);
        System.out.println("=== User Menu ===");
        System.out.println("1. Create Bank Account");
        System.out.println("2. View Bank Accounts");
        System.out.println("3. Logout");
        System.out.print("Select an option: ");
    }

}
