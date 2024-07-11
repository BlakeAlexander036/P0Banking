package com.revature.views;

import com.revature.entities.UserEntity;

import java.util.Scanner;

public class UserRegisterMenuView extends TerminalView {

    public UserRegisterMenuView(Scanner scanner) {
        super(scanner);
    }

    public void displayMenu(UserEntity userEntity) {
        super.displayIsLoggedIn(userEntity);
        System.out.println("=== Register Menu ===");
    }

    public void displayEnterUsername(){
        System.out.print("Enter username: ");
    }

    public void displayEnterPassword(){
        System.out.print("\nEnter Password: ");
    }

}
