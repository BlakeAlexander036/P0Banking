package com.revature.utilities;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseBankAccountPreparedStatements {

/*
            preparedStatement.setInt(1, bankAccountEntity.getAccountNumber());
            preparedStatement.setDouble(2, bankAccountEntity.getBalance());
            preparedStatement.setInt(3, bankAccountEntity.getUserId());
*/

    // Bank Account PreparedStatements

    // Deposit
    public static PreparedStatement getDepositBankAccountPreparedStatement(PreparedStatement preparedStatement, BankAccountEntity bankAccountEntity) throws SQLException {
        preparedStatement.setDouble(1, bankAccountEntity.getBalance());
        preparedStatement.setInt(2, bankAccountEntity.getAccountNumber());
        return preparedStatement;
    }

    // Withdraw
    public static PreparedStatement getWithdrawBankAccountPreparedStatement(PreparedStatement preparedStatement, BankAccountEntity bankAccountEntity) throws SQLException {
        preparedStatement.setDouble(1, bankAccountEntity.getBalance());
        preparedStatement.setInt(2, bankAccountEntity.getAccountNumber());
        return preparedStatement;
    }

    // View Accounts
    public static PreparedStatement getViewBankAccountPreparedStatement(PreparedStatement preparedStatement, BankAccountEntity bankAccountEntity) throws SQLException {
        preparedStatement.setInt(1, bankAccountEntity.getUserId());
        return preparedStatement;
    }

    // create an account
    public static PreparedStatement getCreateBankAccountPreparedStatement(PreparedStatement preparedStatement, BankAccountEntity bankAccountEntity) throws SQLException {
        preparedStatement.setDouble(1, bankAccountEntity.getBalance());
        preparedStatement.setInt(2, bankAccountEntity.getAccountNumber());
        preparedStatement.setInt(3, bankAccountEntity.getUserId());
        return preparedStatement;
    }

    // delete an account
    public static PreparedStatement getDeleteBankAccountPreparedStatement(PreparedStatement preparedStatement, BankAccountEntity bankAccountEntity) throws SQLException {
        preparedStatement.setInt(1, bankAccountEntity.getAccountNumber());
        return preparedStatement;
    }
}
