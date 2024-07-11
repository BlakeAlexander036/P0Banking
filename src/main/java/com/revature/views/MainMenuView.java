package com.revature.views;

import com.revature.entities.UserEntity;

import java.util.Scanner;

public class MainMenuView extends TerminalView {


    public MainMenuView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void displayMenu(UserEntity userEntity) {
        super.displayIsLoggedIn(userEntity);
        System.out.println("=== Main Menu ===");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Select an option: ");
    }

}
