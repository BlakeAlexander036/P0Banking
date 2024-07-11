package com.revature.utilities;

import com.revature.entities.BankAccountEntity;
import com.revature.entities.UserEntity;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUserPreparedStatements {
    /*
        preparedStatement.setString(1, userEntity.getUsername());
        preparedStatement.setString(2, userEntity.getPassword());
    */

    // User PreparedStatements

    public static PreparedStatement getRegisterUserPreparedStatement(PreparedStatement preparedStatement, UserEntity userEntity) throws SQLException {
        preparedStatement.setString(1, userEntity.getUsername());
        preparedStatement.setString(2, userEntity.getPassword());
        return preparedStatement;
    }

    public static PreparedStatement getLoginUserPreparedStatement(PreparedStatement preparedStatement, UserEntity userEntity) throws SQLException {
        preparedStatement.setString(1, userEntity.getUsername());
        preparedStatement.setString(2, userEntity.getPassword());
        return preparedStatement;
    }

}
