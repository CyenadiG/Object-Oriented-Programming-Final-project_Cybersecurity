/*
Job: Manages what notifications are shown to user based on severity
Task breakdown:
    1.Sends SMS notification if the severuty is high/critical
    2. Sends a 'Email' notification if the severity is medium or low
Connection:
    1.Connects to SMSNotif.java to retrieve message for high/critical alerts
    2.Connects to EmailNotif.java to retrieve message for medium/low alerts
Note:
    1. The application does not actually collect users emails or personal info
        so the email notif currently works in a similar nature as SMSNotif
 */
        package MainClasses;

public class NotifManager {
    public static String generateNotification(String severity, String description) {
        String subject = "Security Incident: " + severity;
        String body = description;

        if (severity.equalsIgnoreCase("High") || severity.equalsIgnoreCase("Critical")) {
            return SMSNotif.sendSMS(description);
        } else {
            return EmailNotif.sendEmail(subject, body);
        }
    }
}
