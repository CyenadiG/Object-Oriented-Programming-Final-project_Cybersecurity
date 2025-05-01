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
}
