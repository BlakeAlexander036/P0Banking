package com.revature.controllers;

import com.revature.services.ApplicationManagerService;
import com.revature.services.UserService;
import com.revature.views.MainMenuView;

import java.util.Scanner;

public class MainMenuController extends BaseController {
    private MainMenuView mainMenuView;
    private UserService userService;


    public MainMenuController(Scanner scanner, ApplicationManagerService applicationManagerService, UserService userService) {
        super(scanner, applicationManagerService);
        this.mainMenuView = new MainMenuView(scanner);
        this.userService = userService;
    }

    public void displayMainMenu() {
        mainMenuView.displayMenu();
        String userChoice = mainMenuView.getUserInput();

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        // check action enum to decide controller function to call
        switch(applicationManagerService.getActionEnum()){
            case CREATE: //Register
                register();
                break;
            case READ: //Login
                login();
                break;
            case EXIT: // Exit
                exit();
                break;
        }




    }

    public void register(){
        // when registering, we need to go to the RegisterController
        // simply go back to the ApplicationManager.run() loop
    }

    public void login(){
        // wehn Loginin, we need to go to the LoginController
        // simply go back to the ApplicationManager.run() loop
    }

    public void exit(){
        // When exiting, we need to end the application
        // simply go back to the ApplicationManager.run() loop
    }
}
