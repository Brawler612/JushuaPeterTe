package com.example.jushuapeterte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
        PreparedStatement statement = c.prepareStatement(
                "INSERT INTO users (name, email) VALUES (?,?)"
        )) {
            String name = "Jushua";
            String email = "jushuapeterte@gmail.com";
            statement.setString(1, name);
            statement.setString(2, email);
            int rows = statement.executeUpdate();
            System.out.println("Rows inserted: " + rows);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        //NEW
        try (Connection conn = MySQLConnection.createTables();
             PreparedStatement statement = conn.prepareStatement(
                     "INSERT INTO user_activities (user_id, activity_name) VALUES (?, ?)"
             )) {
            int userId = 1;
            String activityName = "JDBC Activity";

            statement.setInt(1, userId);
            statement.setString(2, activityName);

            int rows = statement.executeUpdate();
            System.out.println("Rows inserted into user_activities: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
