package com.revature.controllers;

import com.revature.entities.BankAccountEntity;
import com.revature.exceptions.BalanceIsNotValidException;
import com.revature.exceptions.BankAccountNumberIsNotValidException;
import com.revature.services.ApplicationManagerService;
import com.revature.services.BankAccountService;
import com.revature.services.UserService;
import com.revature.utilities.ValidatorUtility;
import com.revature.views.BankAccountsMenuView;

import java.util.Scanner;

public class BankAccountsMenuController extends BaseController{
    private BankAccountsMenuView bankAccountsMenuView;
    private BankAccountService bankAccountService;
    private UserService userService;

    public BankAccountsMenuController(Scanner scanner, ApplicationManagerService applicationManagerService, BankAccountService bankAccountService, UserService userService) {
        super(scanner, applicationManagerService);
        this.bankAccountsMenuView = new BankAccountsMenuView(scanner);
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
                bankAccountsMenuView.displayMenu(userService.getUserEntity(), bankAccountService.getBankAccountEntityList());
                userChoice = bankAccountsMenuView.getUserInput();
                isNotValid = !ValidatorUtility.isValidBankAccountNumberInEntityList(userChoice, bankAccountService.getBankAccountEntityList());

            }catch (BankAccountNumberIsNotValidException exception){
                System.out.println(exception.getMessage());
                if(userChoice.equals("0")){ isNotValid = false;}
            }
        }

        // Handle user choice
        // apply action onto enums to see what user has done
        applicationManagerService.applyAction(userChoice);

        // check action enum to decide controller function to call
        switch(applicationManagerService.getActionEnum()){
            case READ: // select the bank account to view menu
                readSelectedBankAccount(userChoice);
                break;
            case EXIT: // Exit
                backToUserMenu();
                break;
        }
    }

    public void readSelectedBankAccount(String bankAccountNumber){
        // make bankAccountEntity = to bank account in bankAccountList(?));
        bankAccountService.setBankAccountEntity(bankAccountService.selectBankAccount(bankAccountNumber));
    }



    //bankAccountService.viewAccounts();

    public void backToUserMenu() {}
}
