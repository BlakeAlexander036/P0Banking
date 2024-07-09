package com.revature.entities;

public abstract class BankAccountEntity {
    private String accountNumber;
    private double balance;

    public BankAccountEntity() {

    }

    // Getters and Setters

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


}
