package com.revature.views;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;

import java.util.Scanner;

public class BankAccountWithdrawView extends TerminalView {

    public BankAccountWithdrawView(Scanner scanner) {
        super(scanner);
    }

    public void displayMenu(UserEntity userEntity, BankAccountEntity bankAccountEntity) {
        super.displayIsLoggedIn(userEntity);
        super.displayCurrentBankAccount(bankAccountEntity);
        System.out.println("=== Withdraw Menu ===");
        System.out.println("Enter the amount you wish to withdraw: ");
    }

}
