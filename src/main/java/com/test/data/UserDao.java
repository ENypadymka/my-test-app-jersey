package com.test.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    DbConnectionSettings dbConn;
    Connection connection;


    public UserDao() {
        dbConn = new DbConnectionSettings();
        connect();
    }

    private void connect() {
        dbConn.getDBConnection();
        connection = dbConn.getDBConnection();
    }

    public void createSchema() {
        PreparedStatement prepStmt = null;
        try {
            String cSQL = "CREATE DATABASE dbusers";
            prepStmt = connection.prepareStatement(cSQL);
            prepStmt.executeUpdate();
        } catch (SQLException ex) {
            prepStmt = null;
            ex.printStackTrace();
        }
    }

    public void addUser(User user) {
        PreparedStatement prepStmt = null;
        try {
            String cSQL = "INSERT INTO dbusers.users VALUES (?, ?, ?)";
            prepStmt = connection.prepareStatement(cSQL);
            prepStmt.setString(2, user.getFirstname());
            prepStmt.setString(3, user.getLastname());
            prepStmt.executeUpdate();
        } catch (SQLException ex) {
            prepStmt = null;
            ex.printStackTrace();
        }
    }

    public List<User> getAllUsers()
    {
        PreparedStatement prepStmt = null;
        List<User> users = new ArrayList<User>();
        try {
            String cSQL = "SELECT * FROM dbusers.users";
            prepStmt = connection.prepareStatement(cSQL);
            ResultSet result = prepStmt.executeQuery();
            while (result.next())
            {
                User user = new User();
                user.setFirstname(result.getString(2));
                user.setLastname(result.getString(3));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            prepStmt = null;
            return null;
        }
    }
}
