package com.revature.views;

import com.revature.entities.UserEntity;

import java.util.Scanner;

public class LoginMenuView extends TerminalView {

    UserEntity userInformation = new UserEntity();

    public LoginMenuView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void displayMenu() {
        System.out.println("=== Login Menu ===");
        enterUsername();
        enterPassword();

    }

    public void enterUsername(){
        System.out.print("Enter username: ");
        userInformation.setUsername(getUserInput());
    }

    public void enterPassword(){
        System.out.print("\nEnter Password: ");
        userInformation.setPassword(getUserInput());
    }

}
