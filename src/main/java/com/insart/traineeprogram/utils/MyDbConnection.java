package com.insart.traineeprogram.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Семья on 11.02.2016.
 */
public class MyDbConnection {
    public static ResourceBundle resourceBundle = ResourceBundle.getBundle("dataBase");

    private static final String DB_URL = resourceBundle.getString("DB_URL");
    private static final String DB_LOGIN = resourceBundle.getString("DB_LOGIN");
    private static final String DB_PASSWORD = resourceBundle.getString("DB_PASSWORD");
    public static final String JDBC_DRIVER = resourceBundle.getString("JDBC_DRIVER");

    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception from getConnection");
            e.printStackTrace();
        }
        return connection;
    }
}
