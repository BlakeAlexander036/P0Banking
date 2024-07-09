package com.revature.views;

import java.util.Scanner;

public class MainMenuView extends TerminalView {


    public MainMenuView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void displayMenu() {
        System.out.println("=== Main Menu ===");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Select an option: ");
    }

}
