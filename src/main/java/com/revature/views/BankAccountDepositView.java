package com.revature.views;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;

import java.util.Scanner;

public class BankAccountDepositView extends TerminalView {

    public BankAccountDepositView(Scanner scanner) {
        super(scanner);
    }

    public void displayMenu(UserEntity userEntity, BankAccountEntity bankAccountEntity) {
        super.displayIsLoggedIn(userEntity);
        super.displayCurrentBankAccount(bankAccountEntity);
        System.out.println("=== Deposit Menu ===");
        System.out.println("Enter the amount you wish to deposit: ");
    }

}
