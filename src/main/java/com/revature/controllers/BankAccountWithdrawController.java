package com.revature.controllers;

import com.revature.services.ApplicationManagerService;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;
import com.revature.views.BankAccountMenuView;
import com.revature.views.BankAccountWithdrawView;

import java.util.Scanner;

public class BankAccountWithdrawController extends BaseController {
    private BankAccountWithdrawView bankAccountWithdrawView;
    private BankAccountService bankAccountService;
    private UserService userService;

    public BankAccountWithdrawController(Scanner scanner, ApplicationManagerService applicationManagerService, BankAccountService bankAccountService, UserService userService) {
        super(scanner, applicationManagerService);
        this.bankAccountWithdrawView = new BankAccountWithdrawView(scanner);
        this.bankAccountService = bankAccountService;
        this.userService = userService;
    }

    // method for calling Terminal view for bank accounts
    public void displayMainMenu() {
        bankAccountWithdrawView.displayMenu(userService.getUserEntity());
        String userChoice = bankAccountWithdrawView.getUserInput();

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        // check action enum to decide controller function to call
        switch(applicationManagerService.getActionEnum()){

        }
    }

    public void withdraw(double withdrawAmount) {
        // call the service to withdraw money
        bankAccountService.withdraw(withdrawAmount);

    }
}
