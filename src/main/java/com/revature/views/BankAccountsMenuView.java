package com.revature.views;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;

import java.util.List;
import java.util.Scanner;

public class BankAccountsMenuView extends TerminalView {

    public BankAccountsMenuView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void displayMenu(UserEntity userEntity) {
        super.displayIsLoggedIn(userEntity);
        //super.displayCurrentBalance(bankAccountEntity);
        System.out.print("Select or Create ('c') a Bank Account: ");
    }

    public void displayAllBankAccounts(List<BankAccountEntity> bankAccountEntityList){

    }

}
