package com.revature.utilities;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Stream;

public class DatabaseScriptRunnerUtility {

    public static void runSQLScript(String sqlFileName, Object entity) {
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
                    setParameters(preparedStatement, entity);
                    preparedStatement.executeUpdate();
                }

                connection.commit();
            }
        } catch (SQLException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void setParameters(PreparedStatement preparedStatement, Object entity) throws SQLException {
        if (entity instanceof UserEntity) {
            UserEntity user = (UserEntity) entity;
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
        } else if (entity instanceof BankAccountEntity) {
            BankAccountEntity account = (BankAccountEntity) entity;
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setDouble(2, account.getBalance());
            preparedStatement.setString(3, account.getUserId());
        }
    }
}
