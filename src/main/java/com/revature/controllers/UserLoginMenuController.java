package com.revature.controllers;

import com.revature.exceptions.UsernameAndPasswordDoesNotExistException;
import com.revature.services.ApplicationManagerService;
import com.revature.services.UserService;
import com.revature.utilities.ValidatorUtility;
import com.revature.views.UserLoginMenuView;

import java.util.Scanner;

public class UserLoginMenuController extends BaseController{
    private UserLoginMenuView userLoginMenuView;
    private UserService userService;



    public UserLoginMenuController(Scanner scanner, ApplicationManagerService applicationManagerService, UserService userService) {
        super(scanner, applicationManagerService);
        this.userLoginMenuView = new UserLoginMenuView(scanner);
        this.userService = userService;

    }

    public void displayMenu() {
        boolean isNotValid = true;
        String userChoice = "";

        while(isNotValid){
            try{
                userLoginMenuView.displayMenu(userService.getUserEntity());
                userLoginMenuView.displayEnterUsername();

                // set the User Entity username to input
                userChoice = userLoginMenuView.getUserInput();
                if(userChoice.equals("0")) {break;}
                userService.setUsername(userChoice);

                // set the User Entity password to input
                userLoginMenuView.displayEnterPassword();
                userChoice = userLoginMenuView.getUserInput();
                if(userChoice.equals("0")) {break;}
                userService.setPassword(userChoice);

                login();

                isNotValid = ValidatorUtility.isValidPasswordAndUsernameLoginUserInDB(userService.getUserEntity());
            } catch (UsernameAndPasswordDoesNotExistException exception){
                System.out.println(exception.getMessage());
            }
        }


        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);



    }

    public void login(){
        // login needs to check to see if a user does exist in the database
        // if user does exist, we need to retrieve the user_id and place it into the entity data
        // if user does not exist, we need to give the user an error message
        userService.loginUser();
    }


}
