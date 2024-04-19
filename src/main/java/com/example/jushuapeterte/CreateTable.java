package com.example.jushuapeterte;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        try (Connection c = MySQLConnection.getConnection();
            Statement statement = c.createStatement()) {
                String query = "CREATE TABLE users (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                        "name VARCHAR(50) NOT NULL)";
                statement.execute(query);
                System.out.println("Table created successfully.");
            } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
