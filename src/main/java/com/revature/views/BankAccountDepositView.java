package com.revature.views;

import com.revature.entities.UserEntity;

import java.util.Scanner;

public class BankAccountDepositView extends TerminalView {

    public BankAccountDepositView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void displayMenu(UserEntity userEntity) {
        super.displayIsLoggedIn(userEntity);
        //super.displayCurrentBalance(bankAccountEntity);
        //System.out.println("Your Currrent Balance is $" + displayBalance());
        System.out.println("=== Deposit Menu ===");
        System.out.println("Enter the amount you wish to deposit: ");
    }

}
