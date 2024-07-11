package com.revature.controllers;

import com.revature.exceptions.BalanceIsNotValidException;
import com.revature.services.ApplicationManagerService;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;
import com.revature.utilities.ValidatorUtility;
import com.revature.views.BankAccountDepositView;

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
    public void displayMenu() {
        String userChoice = "";

        // set the User Entity username to input
        boolean isNotValid = true;
        while(isNotValid){
            try{
                bankAccountDepositView.displayMenu(userService.getUserEntity(), bankAccountService.getBankAccountEntity());
                userChoice = bankAccountDepositView.getUserInput();
                isNotValid = !ValidatorUtility.isValidBalance(userChoice);
            }catch (BalanceIsNotValidException exception){
                System.out.println(exception.getMessage());
            }
        }
        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        deposit(Double.parseDouble(userChoice));
    }

    public void deposit(double depositAmount) {
        // call the service to deposit money
        bankAccountService.deposit(depositAmount);
    }
}
