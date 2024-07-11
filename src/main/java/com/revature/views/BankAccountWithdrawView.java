package com.revature.views;

import com.revature.entities.UserEntity;

import java.util.Scanner;

public class BankAccountWithdrawView extends TerminalView {

    public BankAccountWithdrawView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void displayMenu(UserEntity userEntity) {
        super.displayIsLoggedIn(userEntity);
        //super.displayCurrentBalance(bankAccountEntity);
        System.out.println("=== Withdraw Menu ===");
        System.out.println("Enter the amount you wish to withdraw: ");
    }

}
