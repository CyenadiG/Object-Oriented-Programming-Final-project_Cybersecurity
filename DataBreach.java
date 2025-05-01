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
}
