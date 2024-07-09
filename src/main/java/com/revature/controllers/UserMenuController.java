package com.revature.controllers;

import com.revature.entities.UserEntity;
import com.revature.services.UserService;
import com.revature.views.MainMenuView;
import com.revature.views.UserMenuView;

import java.util.Scanner;

public class UserMenuController {
    private UserMenuView userMenuView;
    private UserService userService;
    private Scanner scanner;

    public UserMenuController(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.userMenuView = new UserMenuView(scanner);
        this.userService = userService;
    }

    public void displayMainMenu() {
        userMenuView.displayMenu();
        String choice = userMenuView.getUserInput();
        // Handle user choice
    }

}

