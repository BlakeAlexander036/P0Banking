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
    //private UserEntity userEntity;
    //private BankAccountEntity bankAccountEntity;



    public ApplicationManager(Scanner scanner) {
        this.scanner = scanner;

        // Initialize repositories, services, controllers, and views
        this.bankAccountService = new BankAccountService();
        this.userService = new UserService();

        this.userMenuController = new UserMenuController(scanner, userService); // this needs a UserService to display who is logged in
        this.bankAccountMenuController = new BankAccountMenuController(scanner,bankAccountService); // this needs a BankAccountService
        this.userMenuController = new UserMenuController(scanner,userService); // this needs the UserService to display who is logged in
        this.loginMenuController = new LoginMenuController(scanner,userService); // this needs the UserService
        this.registerMenuController = new RegisterMenuController(scanner,userService); // this needs the UserService
    }

    // Method to run the application
    public void run() {
        // Main loop for the application

        // WE JUST WANT CONTROLLERS HERE IM PRETTY SURE
        // Welcome... and TerminalView popup


        // login / register / quit

        // once logged in... Bank account CRUD, User CRUD, Quit

    }
}
