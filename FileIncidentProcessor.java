/*
Job: Processes incident data from a file
Task breakdown:
    1.Reads incident data from the file and processes each incident
Connection:
    1. Reads the user-uploaded file and passes the data to SeverityClassifier.java for severity classification
    2.Creates an incident object and stores it in the IncidentDAO.java database
 */
package MainClasses;

import dao.IncidentDAO;
import model.Incident;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class FileIncidentProcessor {

    private final IncidentDAO incidentDAO;
    private final int currentUserId;

    public FileIncidentProcessor(int userId) {
        this.incidentDAO = new IncidentDAO();
        this.currentUserId = userId;
    }

    public static void processFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Classify the severity of the line
                String severity = SeverityClassifier.classify(line);

                // Create new Incident
                Incident incident = new Incident();
                incident.type = "Detected Incident";
                incident.description = line;
                incident.severity = severity;
                incident.status = "open";
                incident.reportedBy = AuthManager.currentUserID;

                // Store the incident in the database
                IncidentDAO.addIncident(incident);
                System.out.println("Incident added: " + line + " (Severity: " + severity + ")");
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to process the file.");
        }
    }
}


