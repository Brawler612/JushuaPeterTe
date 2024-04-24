package com.example.jushuapeterte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
                    "UPDATE users SET name=? WHERE id=?"
            )) {
            String name = "Jushua Peter P. Te";
            int id = 2;
            statement.setString(1, name);
            statement.setInt(2, id);
            int rows = statement.executeUpdate();
            System.out.println("Rows updated: " + rows);
        } catch(SQLException e) {
            e.printStackTrace();
        }

        //NEW
        try (Connection conn = MySQLConnection.createTables();
             PreparedStatement statement = conn.prepareStatement(
                     "UPDATE user_activities SET activity_name=? WHERE activity_id=?"
             )) {
            String updatedActivityName = null;
            int activityId = 0;

            statement.setString(1, updatedActivityName);
            statement.setInt(2, activityId);

            int rows = statement.executeUpdate();
            System.out.println("Rows updated in user_activities: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
