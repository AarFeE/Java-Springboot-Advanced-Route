package com.aarfee.persistance.configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConfig {
    private static Connection connection = null;

    public static Connection openConnection() {
        String URL = "jdbc:mysql://localhost:3306/Riwi_Manager";
        String user = "root";
        String password = "-4lg3br4t0SQL-";

        try {
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("Connection to DB was Successful!");
        } catch(SQLException e){
            throw new RuntimeException("SQL Error: " + e.getMessage());
        }

        return connection;
    }

    public static void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
                System.out.println("Connection to DB closed Correctly!");
            } catch (SQLException e) {
                throw new RuntimeException("SQL Error: " + e.getMessage());
            }
        }
    }
}
