package com.revature.controllers;

import com.revature.exceptions.BalanceIsNotValidException;
import com.revature.exceptions.WithdrawIsNotValidException;
import com.revature.services.ApplicationManagerService;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;
import com.revature.utilities.ValidatorUtility;
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
    public void displayMenu() {
        String userChoice = "";

        // set the User Entity username to input
        boolean isNotValid = true;
        boolean isNotValidWithdraw = true;
        while(isNotValid){
            try{
                bankAccountWithdrawView.displayMenu(userService.getUserEntity(), bankAccountService.getBankAccountEntity());
                userChoice = bankAccountWithdrawView.getUserInput();
                isNotValid = !ValidatorUtility.isValidWithdraw(userChoice, bankAccountService.getBankAccountBalance());
            }catch (WithdrawIsNotValidException exception){
                System.out.println(exception.getMessage());
            }
        }

        // check action enum to decide controller function to call
        applicationManagerService.applyAction(userChoice);

        withdraw(Double.parseDouble(userChoice));
    }


    public void withdraw(double withdrawAmount) {
        // call the service to withdraw money
        bankAccountService.withdraw(withdrawAmount);

    }
}
