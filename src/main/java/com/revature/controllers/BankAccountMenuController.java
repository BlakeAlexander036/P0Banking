package com.revature.controllers;

import com.revature.services.ApplicationManagerService;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;
import com.revature.views.BankAccountMenuView;


import java.util.Scanner;

public class BankAccountMenuController extends BaseController{
    private BankAccountMenuView bankAccountMenuView;
    private BankAccountService bankAccountService;
    private UserService userService;

    public BankAccountMenuController(Scanner scanner, ApplicationManagerService applicationManagerService, BankAccountService bankAccountService, UserService userService) {
        super(scanner, applicationManagerService);
        this.bankAccountMenuView = new BankAccountMenuView(scanner);
        this.bankAccountService = bankAccountService;
        this.userService = userService;
    }

    // method for calling Terminal view for bank accounts
    public void displayMenu() {
        bankAccountMenuView.displayMenu(userService.getUserEntity(), bankAccountService.getBankAccountEntity());
        String userChoice = bankAccountMenuView.getUserInput();

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        // check action enum to decide controller function to call

    }

    // Methods for handling account creation, deposit, withdraw, view accounts
    public void updateBalance() {
        // simply go back to the ApplicationManager.run() loop
    }

    public void closeAccount(){
        // simply go back to the ApplicationManager.run() loop
    }

}

