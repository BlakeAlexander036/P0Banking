package com.revature.views;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;

import java.util.List;
import java.util.Scanner;

public class BankAccountsMenuView extends TerminalView {

    public BankAccountsMenuView(Scanner scanner) {
        super(scanner);
    }

    public void displayMenu(UserEntity userEntity, List<BankAccountEntity> bankAccountEntityList) {
        super.displayIsLoggedIn(userEntity);
        displayAllBankAccounts(bankAccountEntityList);
        System.out.println("=== Bank Accounts Menu ===");
        System.out.println("0. Exit ");
        System.out.print("Select a Bank Account by its Bank Account Number or exit ('0'): ");
    }

    public void displayAllBankAccounts(List<BankAccountEntity> bankAccountEntityList){
        if (bankAccountEntityList == null || bankAccountEntityList.isEmpty()) {
            System.out.println("No bank accounts to display.");
            return;
        }

        System.out.println("=== Bank Accounts ===");
        for(BankAccountEntity bankAccountEntity : bankAccountEntityList){
            System.out.println(bankAccountEntity.toString());
        }
    }

}
