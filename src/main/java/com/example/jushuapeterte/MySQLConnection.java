package com.example.jushuapeterte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//NEW
import java.sql.Statement;
import java.sql.PreparedStatement;


public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/dbte";
    private static final String USER = "root";
    public static final String PASS ="";

    //NEW
    static {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("Failed to register MySQL driver");
        }
    }

    //NEW
    public static Connection createTables() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        Statement statement = conn.createStatement();
        try {
            // Create users table
            String createUsersTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(50) NOT NULL,"
                    + "email VARCHAR(100) NOT NULL"
                    + ")";
            statement.executeUpdate(createUsersTableSQL);

            // Create user_activities table
            String createUserActivitiesTableSQL = "CREATE TABLE IF NOT EXISTS user_activities ("
                    + "activity_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "user_id INT,"
                    + "activity_name VARCHAR(255),"
                    + "activity_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                    + "FOREIGN KEY (user_id) REFERENCES users(id)"
                    + ")";
            statement.executeUpdate(createUserActivitiesTableSQL);

            // Insert a custom value into user_activities table
            String insertActivitySQL = "INSERT INTO user_activities (user_id, activity_name) VALUES (?, ?)";
            PreparedStatement insertStatement = conn.prepareStatement(insertActivitySQL);
            insertStatement.setInt(1, 1);
            insertStatement.setString(2, "JDBC Activity");
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create tables", e);
        }

        return conn;
    }


    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Yo@!");
        } catch (SQLException | ClassNotFoundException e ) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = MySQLConnection.getConnection();
    }
}