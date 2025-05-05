/*
Job: Defines the basic structure of an Incident
Task breakdown:
    1.Stores common attributes for incidents like id, description, severity, etc.
Connection:
    1. Used by FileIncidentProcessor.java to represent incidents
    2. Stored in the IncidentDAO.java database
 */
package model;

import java.time.LocalDateTime;

public class Incident {
    public int id;
    public String type;
    public String description;
    public String severity;
    public String status;
    public LocalDateTime timestamp;
    public int reportedBy;

    // Constructor, Getters and Setters
    public Incident() {
        
    }

    public Incident(String description, String severity, int reportedBy) {
        this.description = description;
        this.severity = severity;
        this.status = "open";  // Default status
        this.timestamp = LocalDateTime.now();  // Default to current time
        this.reportedBy = reportedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(int reportedBy) {
        this.reportedBy = reportedBy;
    }
}

