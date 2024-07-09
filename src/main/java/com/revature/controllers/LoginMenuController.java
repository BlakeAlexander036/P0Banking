package com.revature.controllers;

import com.revature.services.UserService;
import com.revature.views.LoginMenuView;

import java.util.Scanner;

public class LoginMenuController {
    private LoginMenuView loginView;
    private UserService userService;
    private Scanner scanner;


    public LoginMenuController(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.loginView = new LoginMenuView(scanner);
        this.userService = userService;

    }

    public void displayLoginMenu() {
        loginView.displayMenu();

        // Handle login
    }

    public void getEntityData(){

    }

    public void saveEntityData(){

    }


}
