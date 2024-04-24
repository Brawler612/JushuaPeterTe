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

        //NEW
        try (Connection conn = MySQLConnection.createTables();
             Statement statement = conn.createStatement()) {
            String query = "CREATE TABLE IF NOT EXISTS user_activities ("
                    + "activity_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "user_id INT,"
                    + "activity_name VARCHAR(255),"
                    + "activity_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                    + "FOREIGN KEY (user_id) REFERENCES users(id)"
                    + ")";
            statement.executeUpdate(query);
            System.out.println("user_activities table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
