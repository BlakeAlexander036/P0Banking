package com.revature.controllers;

import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.exceptions.UsernameIsNotValidException;
import com.revature.services.ApplicationManagerService;
import com.revature.services.UserService;
import com.revature.utilities.ValidatorUtility;
import com.revature.views.UserRegisterMenuView;

import java.util.Scanner;

public class UserRegisterMenuController extends BaseController{
    private UserRegisterMenuView userRegisterMenuView;
    private UserService userService;
    String userChoice;

    public UserRegisterMenuController(Scanner scanner, ApplicationManagerService applicationManagerService, UserService userService) {
        super(scanner, applicationManagerService);
        this.userRegisterMenuView = new UserRegisterMenuView(scanner);
        this.userService = userService;
    }

    public void displayMenu() {
        // Handle login
        userRegisterMenuView.displayMenu(userService.getUserEntity());

        // set the User Entity username to input
        boolean isNotLoggedIn = true;

        while(isNotLoggedIn) {
            boolean isNotValid = true;
            while (isNotValid) {
                try {
                    userRegisterMenuView.displayEnterUsername();
                    userChoice = userRegisterMenuView.getUserInput();
                    isNotValid = !ValidatorUtility.isValidUsername(userChoice);
                } catch (UsernameIsNotValidException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            userService.setUsername(userChoice);


            // set the User Entity password to input
            isNotValid = true;
            while (isNotValid) {
                try {
                    userRegisterMenuView.displayEnterPassword();
                    userChoice = userRegisterMenuView.getUserInput();
                    isNotValid = !ValidatorUtility.isValidPassword(userChoice);
                } catch (UsernameIsNotValidException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            userService.setPassword(userChoice);

            register();

            try {
                isNotLoggedIn = !ValidatorUtility.isRegistered(userService.getUserEntity());
            } catch (UsernameAlreadyExistsException exception){
                System.out.println(exception.getMessage());
            }
        }

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);


    }

    public void register(){
        // call userService to register
        userService.registerUser();
    }
}