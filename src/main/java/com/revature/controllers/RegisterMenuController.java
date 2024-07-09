package com.revature.controllers;

import com.revature.services.UserService;
import com.revature.views.RegisterMenuView;

import java.util.Scanner;

public class RegisterMenuController {
    private RegisterMenuView registerView;
    private Scanner scanner;
    private UserService userService;

    public RegisterMenuController(Scanner scanner, UserService userService) {
        this.scanner = scanner;
        this.registerView = new RegisterMenuView(scanner);
        this.userService = userService;
    }

    public void displayLoginMenu() {
        registerView.displayMenu();
        String username = registerView.getUserInput();
        // Handle login
    }
}