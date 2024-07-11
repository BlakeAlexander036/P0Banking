package com.revature.utilities;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;
import com.revature.entities.UserInputEntity;
import com.revature.enums.ActionEnum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DatabaseScriptRunnerUtility {

    public static void runSQLScript(String sqlFileName, Object entity, ActionEnum actionEnum) {
        Path sqlPath = Paths.get("src/main/resources/scripts/" + sqlFileName);
        try {
            try (
                    Connection connection = DatabaseConnectorUtility.createConnection();
                    Stream<String> lines = Files.lines(sqlPath)
            ) {
                connection.setAutoCommit(false);
                StringBuilder sqlBuilder = new StringBuilder();
                lines.forEach(line -> sqlBuilder.append(line).append("\n"));
                String sql = sqlBuilder.toString();

                // Prepare the statement
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    setParameters(preparedStatement, entity, actionEnum);
                    preparedStatement.executeUpdate();
                }

                connection.commit();
            }
        } catch (SQLException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static List<Object> runSQLSelectScript(String sqlFileName, Object entity, ActionEnum actionEnum) {
        Path sqlPath = Paths.get("src/main/resources/scripts/" + sqlFileName);
        List<Object> results = new ArrayList<>();
        try {
            try (
                    Connection connection = DatabaseConnectorUtility.createConnection();
                    Stream<String> lines = Files.lines(sqlPath)
            ) {
                connection.setAutoCommit(false);
                StringBuilder sqlBuilder = new StringBuilder();
                lines.forEach(line -> sqlBuilder.append(line).append("\n"));
                String sql = sqlBuilder.toString();

                // Prepare the statement
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    setParameters(preparedStatement, entity, actionEnum);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        if (entity instanceof UserEntity) {
                            UserEntity user = new UserEntity();
                            user.setUsername(resultSet.getString("username"));
                            user.setPassword(resultSet.getString("password"));
                            user.setUserId(resultSet.getInt("user_id"));
                            results.add(user);
                        } else if (entity instanceof BankAccountEntity) {
                            BankAccountEntity account = new BankAccountEntity();
                            account.setAccountNumber(resultSet.getInt("account_number"));
                            account.setBalance(resultSet.getDouble("balance"));
                            account.setUserId(resultSet.getInt("user_id"));
                            results.add(account);
                        }
                    }
                }

                connection.commit();
            }
        } catch (SQLException | IOException exception) {
            System.out.println(exception.getMessage());
        }
        return results;
    }

    private static void setParameters(PreparedStatement preparedStatement, Object entity, ActionEnum actionEnum) throws SQLException {
        if (entity instanceof UserEntity) {
            UserEntity userEntity = (UserEntity) entity;
            switch(actionEnum){
                case READ:
                    DatabaseUserPreparedStatements.getLoginUserPreparedStatement(preparedStatement, userEntity);
                    break;
                case CREATE:
                    DatabaseUserPreparedStatements.getRegisterUserPreparedStatement(preparedStatement, userEntity);
                    break;
            }

        } else if (entity instanceof BankAccountEntity) {
            BankAccountEntity bankAccountEntity = (BankAccountEntity) entity;
            switch(actionEnum){
                case DEPOSIT:
                    DatabaseBankAccountPreparedStatements.getDepositBankAccountPreparedStatement(preparedStatement, bankAccountEntity);
                    break;
                case WITHDRAW:
                    DatabaseBankAccountPreparedStatements.getWithdrawBankAccountPreparedStatement(preparedStatement, bankAccountEntity);
                case CREATE:
                    DatabaseBankAccountPreparedStatements.getCreateBankAccountPreparedStatement(preparedStatement, bankAccountEntity);
                    break;
                case READ:
                    DatabaseBankAccountPreparedStatements.getViewBankAccountPreparedStatement(preparedStatement, bankAccountEntity);
                    break;

            }
        }
    }
}
