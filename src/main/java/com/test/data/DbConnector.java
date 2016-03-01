package com.test.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TODO: Must be reimplemented to singleton
public class DbConnector {

    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/dbusers";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public Connection getDBConnection() {

        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Can't create connection." + e.getMessage());

        }

        return conn;

    }

}
