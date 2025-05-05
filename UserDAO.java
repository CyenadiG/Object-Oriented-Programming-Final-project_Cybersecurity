package dao;

/*
Job: Handles interactions with the database for User data
Task breakdown:
    1.Retrieves a user by their username
    2.adds new users to database
Connection:
    1. Interacts with PostgreSQL database through DBConnection
 */

import db.DBConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public User getUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPasswordHash(rs.getString("password_hash"));
                user.setRole(rs.getString("role"));
                return user;
            }
        }
        return null;
    }

    public boolean addUser(User newUser) throws SQLException {
        String sql = "INSERT INTO users (username, password_hash, role) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newUser.getUsername());
            stmt.setString(2, newUser.getPasswordHash());
            stmt.setString(3, newUser.getRole());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        }
    }

}
