package com.revature.controllers;

import com.revature.services.UserService;
import com.revature.views.MainMenuView;

import java.util.Scanner;

public class MainMenuController {
    private MainMenuView mainMenuView;
    private Scanner scanner;
    private UserService userService;

    public MainMenuController(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.mainMenuView = new MainMenuView(scanner);
        this.userService = userService;
    }

    public void displayMainMenu() {
        mainMenuView.displayMenu();
        String choice = mainMenuView.getUserInput();
        // Handle user choice
    }

    public void register(){
        // when registering, we need to go to the RegisterController
    }

    public void login(){
        // wehn Loginin, we need to go to the LoginController
    }

    public void exit(){
        // When exiting, we need to end the application
    }
}
