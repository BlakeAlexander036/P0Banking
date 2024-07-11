package com.revature.controllers;

import com.revature.services.ApplicationManagerService;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;
import com.revature.views.BankAccountDepositView;
import com.revature.views.BankAccountMenuView;

import java.util.Scanner;

public class BankAccountDepositController extends BaseController{

    private BankAccountDepositView bankAccountDepositView;
    private BankAccountService bankAccountService;
    private UserService userService;

    public BankAccountDepositController(Scanner scanner, ApplicationManagerService applicationManagerService, BankAccountService bankAccountService, UserService userService) {
        super(scanner, applicationManagerService);
        this.bankAccountDepositView = new BankAccountDepositView(scanner);
        this.bankAccountService = bankAccountService;
        this.userService = userService;
    }

    // method for calling Terminal view for bank accounts
    public void displayMainMenu() {
        bankAccountDepositView.displayMenu(userService.getUserEntity());
        String userChoice = bankAccountDepositView.getUserInput();

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        // check action enum to decide controller function to call
        switch(applicationManagerService.getActionEnum()){

        }
    }

    public void deposit(double depositAmount) {
        // call the service to deposit money
        bankAccountService.deposit(depositAmount);
    }
}
