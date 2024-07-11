package com.revature.controllers;

import com.revature.entities.UserEntity;
import com.revature.services.ApplicationManagerService;
import com.revature.services.UserService;
import com.revature.views.LoginMenuView;

import java.util.Scanner;

public class LoginMenuController extends BaseController{
    private LoginMenuView loginMenuView;
    private UserService userService;



    public LoginMenuController(Scanner scanner, ApplicationManagerService applicationManagerService, UserService userService) {
        super(scanner, applicationManagerService);
        this.loginMenuView = new LoginMenuView(scanner);
        this.userService = userService;

    }

    public void displayLoginMenu() {
        loginMenuView.displayMenu(userService.getUserEntity());
        loginMenuView.displayEnterUsername();

        // set the User Entity username to input
        String userChoice = loginMenuView.getUserInput();
        userService.setUsername(userChoice);

        // set the User Entity password to input
        loginMenuView.displayEnterPassword();
        userChoice = loginMenuView.getUserInput();
        userService.setPassword(userChoice);

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        login();

    }

    public void login(){
        // login needs to check to see if a user does exist in the database
        // if user does exist, we need to retrieve the user_id and place it into the entity data
        // if user does not exist, we need to give the user an error message
        userService.loginUser();
    }


}
