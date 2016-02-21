package com.test.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionSettings {
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/dbuser?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }


}
