package com.example.jushuapeterte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/dbte";
    private static final String USER = "root";
    public static final String PASS ="";

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