package com.revature.entities;

public class BankAccountEntity {
    private String accountNumber;
    private double balance;
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
