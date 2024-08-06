package com.aarfee.persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConfig {
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/RiwiAcademyDB";
    private static String user = "root";
    private static String password = "tupassword";

    public static Connection openConnection() {

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection To DB Properly Created!");
        } catch (SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }

        return  connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection Properly Closed!");
            } catch (SQLException e) {
                throw new RuntimeException("SQL Error: " + e.getMessage());
            }
        }
    }
}
