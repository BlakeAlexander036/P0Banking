package com.revature.views;

import com.revature.entities.UserEntity;

import java.util.Scanner;

public class RegisterMenuView extends TerminalView {

    public RegisterMenuView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void displayMenu(UserEntity userEntity) {
        super.displayIsLoggedIn(userEntity);
        System.out.println("=== Login Menu ===");
    }

    public void displayEnterUsername(){
        System.out.print("Enter username: ");
    }

    public void displayEnterPassword(){
        System.out.print("\nEnter Password: ");
    }

}
