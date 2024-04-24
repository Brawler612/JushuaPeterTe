package com.example.jushuapeterte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ReadData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            Statement statement = c.createStatement()) {
                String query = "SELECT * FROM users";
                ResultSet res = statement.executeQuery(query);
                while(res.next()) {
                    int id = res.getInt("id");
                    String name = res.getString("name");
                    String email = res.getString("email");
                    System.out.println("ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Email: " + email);
                }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        //NEW
        try (Connection conn = MySQLConnection.createTables();
             Statement statement = conn.createStatement()) {
            String query = "SELECT * FROM user_activities";
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                int activityId = res.getInt("activity_id");
                int userId = res.getInt("user_id");
                String activityName = res.getString("activity_name");
                String activityDate = res.getString("activity_date");

                System.out.println("Activity ID: " + activityId);
                System.out.println("User ID: " + userId);
                System.out.println("Activity Name: " + activityName);
                System.out.println("Activity Date: " + activityDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
