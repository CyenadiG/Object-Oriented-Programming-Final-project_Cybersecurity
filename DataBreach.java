/*
Job: Defines the DataBreach incident type
Task breakdown:
    1. Stores specific details about data breaches, sucb as the type of leaked data
Connection:
    1. Extends the Incident class
    2.Used in FileIncidentProcessor.java to create a DataBreach instance for incidents with that type
 */

package model;

public class DataBreach extends Incident {
    private String leakedData;

    public DataBreach(String description, String severity, int reportedBy, String leakedData) {
        this.type = "Data Breach";
        this.description = description;
        this.severity = severity;
        this.status = "open";
        this.reportedBy = reportedBy;
        this.leakedData = leakedData;
    }

    // Getters/Setters
    public String getLeakedData() {
        return leakedData;
    }

    public void setLeakedData(String leakedData) {
        this.leakedData = leakedData;
    }


}
