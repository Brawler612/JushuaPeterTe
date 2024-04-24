package com.example.jushuapeterte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement(
                    "DELETE FROM users WHERE id=? RETURNING *"
            )) {
            int id = 1;
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            ResultSet res = statement.getResultSet();
            if(res.next()) {
                System.out.println("Name: " + res.getString("name"));
                System.out.println("Email: " + res.getString("email"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        try (Connection conn = MySQLConnection.createTables();
             PreparedStatement statement = conn.prepareStatement(
                     "DELETE FROM user_activities WHERE activity_id=?"
             )) {
            int activityIdToDelete = 1;

            statement.setInt(1, activityIdToDelete);

            int rowsDeleted = statement.executeUpdate();
            System.out.println("Rows deleted from user_activities: " + rowsDeleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
