package com.revature.controllers;

import com.revature.services.ApplicationManagerService;
import com.revature.services.UserService;
import com.revature.views.RegisterMenuView;

import java.util.Scanner;

public class RegisterMenuController extends BaseController{
    private RegisterMenuView registerMenuView;
    private UserService userService;

    public RegisterMenuController(Scanner scanner, ApplicationManagerService applicationManagerService, UserService userService) {
        super(scanner, applicationManagerService);
        this.registerMenuView = new RegisterMenuView(scanner);
        this.userService = userService;
    }

    public void displayLoginMenu() {
        registerMenuView.displayMenu();
        String username = registerMenuView.getUserInput();
        // Handle login
        registerMenuView.displayMenu();
        registerMenuView.displayEnterUsername();

        // set the User Entity username to input
        registerMenuView.displayEnterPassword();
        String userChoice = registerMenuView.getUserInput();
        userService.setUsername(userChoice);

        // set the User Entity password to input
        userChoice = registerMenuView.getUserInput();
        userService.setPassword(userChoice);

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        register();
    }

    public void register(){
        // when registering we need to validate
        // call userService to register
        userService.registerUser();
    }
}