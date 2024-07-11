package com.revature.controllers;

import com.revature.exceptions.UsernameIsNotValidException;
import com.revature.services.ApplicationManagerService;
import com.revature.services.UserService;
import com.revature.utilities.ValidatorUtility;
import com.revature.views.RegisterMenuView;

import java.util.Scanner;

public class RegisterMenuController extends BaseController{
    private RegisterMenuView registerMenuView;
    private UserService userService;
    String userChoice;

    public RegisterMenuController(Scanner scanner, ApplicationManagerService applicationManagerService, UserService userService) {
        super(scanner, applicationManagerService);
        this.registerMenuView = new RegisterMenuView(scanner);
        this.userService = userService;
    }

    public void displayLoginMenu() {
        // Handle login
        registerMenuView.displayMenu(userService.getUserEntity());

        // set the User Entity username to input
        boolean isNotValid = true;
        while(isNotValid){
            try{
                registerMenuView.displayEnterUsername();
                userChoice = registerMenuView.getUserInput();
                isNotValid = !ValidatorUtility.isValidUsername(userChoice);
            }catch (UsernameIsNotValidException exception){
                System.out.println(exception.getMessage());
            }
        }
        userService.setUsername(userChoice);


        // set the User Entity password to input
        isNotValid = true;
        while(isNotValid){
            try{
                registerMenuView.displayEnterPassword();
                userChoice = registerMenuView.getUserInput();
                isNotValid = !ValidatorUtility.isValidPassword(userChoice);
            }catch (UsernameIsNotValidException exception){
                System.out.println(exception.getMessage());
            }
        }
        userService.setPassword(userChoice);

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        register();
    }

    public void register(){
        // call userService to register
        userService.registerUser();
    }
}