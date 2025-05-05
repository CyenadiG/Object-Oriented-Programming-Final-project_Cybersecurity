/*
Job: Handles interactions with the database for Incident data
Task breakdown:
    1.adds new incidents to the database
    2.retrieves all incidents from database
Connection:
    1. Interacts with PostgreSQL database through DBConnection
 */

package dao;

import db.DBConnection;
import model.Incident;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IncidentDAO {

    public static void addIncident(Incident incident) throws SQLException {
        String sql = "INSERT INTO incidents (type, description, severity, status, reported_by) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, incident.type);
            stmt.setString(2, incident.description);
            stmt.setString(3, incident.severity);
            stmt.setString(4, incident.status);
            stmt.setInt(5, incident.reportedBy);
            stmt.executeUpdate();
        }
    }

    public List<Incident> getAllIncidents() throws SQLException {
        List<Incident> incidents = new ArrayList<>();
        String sql = "SELECT * FROM incidents";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Incident inc = new Incident();
                inc.id = rs.getInt("id");
                inc.type = rs.getString("type");
                inc.description = rs.getString("description");
                inc.severity = rs.getString("severity");
                inc.status = rs.getString("status");
                inc.timestamp = rs.getTimestamp("timestamp").toLocalDateTime();
                inc.reportedBy = rs.getInt("reported_by");
                incidents.add(inc);
            }
        }
        return incidents;
    }
}
