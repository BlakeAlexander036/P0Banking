package com.revature.manager;

import com.revature.controllers.*;
import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;

import java.util.Scanner;

public class ApplicationManager {
    //Scanner
    Scanner scanner;

    // Controllers
    private UserMenuController userMenuController;
    private BankAccountMenuController bankAccountMenuController;
    private LoginMenuController loginMenuController;
    private MainMenuController mainMenuController;
    private RegisterMenuController registerMenuController;

    // Services
    private BankAccountService bankAccountService;
    private UserService userService;

    // Entities
    private UserEntity userEntity;
    private BankAccountEntity bankAccountEntity;



    public ApplicationManager(Scanner scanner) {
        this.scanner = scanner;

        // Initialize entities, repositories, services, controllers, and views

        //Entities
        this.userEntity = new UserEntity();
        this.bankAccountEntity = new BankAccountEntity();

        // Services
        this.bankAccountService = new BankAccountService(bankAccountEntity);
        this.userService = new UserService(userEntity);

        // Controllers
        this.mainMenuController = new MainMenuController(scanner, userService); // this needs a UserService to display who is logged in
        this.bankAccountMenuController = new BankAccountMenuController(scanner,bankAccountService); // this needs a BankAccountService
        this.userMenuController = new UserMenuController(scanner,userService); // this needs the UserService to display who is logged in
        this.loginMenuController = new LoginMenuController(scanner,userService); // this needs the UserService
        this.registerMenuController = new RegisterMenuController(scanner,userService); // this needs the UserService
    }

    // Method to run the application
    public void run() {
        // Welcome... and TerminalView popup
        enum selection = mainMenuController.displayMainMenu(); // this needs to return a value to determine the next controller

        // THIS IS THE PLAN
        /*
            we will have an enum that contains every possible user input option for changing a controller, that
            enum will then call the controller we want.
        */


        // Main loop for the application
        while(true){
            // WE JUST WANT CONTROLLERS HERE IM PRETTY SURE
            selectController(enum);


            // login / register / quit

            // once logged in... Bank account CRUD, User CRUD, Quit
        }
    }

    public void seletcController(enum value){
        switch(value){

        }
    }
}
