package com.revature.views;

import java.util.Scanner;

public class RegisterMenuView extends TerminalView {

    public RegisterMenuView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void displayMenu() {
        System.out.println("=== Login Menu ===");
        System.out.print("Enter username: ");
    }

    public void displayEnterUsername(){
        System.out.print("Enter username: ");
    }

    public void displayEnterPassword(){
        System.out.print("\nEnter Password: ");
    }

}
