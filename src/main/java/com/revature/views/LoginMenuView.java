package com.revature.views;

import com.revature.entities.UserEntity;

import java.util.Scanner;

public class LoginMenuView extends TerminalView {

    UserEntity userInformation = new UserEntity();

    public LoginMenuView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void displayMenu(UserEntity userEntity) {
        super.displayIsLoggedIn(userEntity);
        System.out.println("=== Login Menu ===");
        System.out.println("Please enter your Username and Password");
    }

    public void displayEnterUsername(){
        System.out.print("Enter username: ");
    }

    public void displayEnterPassword(){
        System.out.print("\nEnter Password: ");
    }

}
