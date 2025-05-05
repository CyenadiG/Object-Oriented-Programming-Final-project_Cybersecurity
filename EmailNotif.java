/*
Job: Creates message for medium/low severities
Task breakdown:
    1. Sends an "Email" to user with constructed message
Connection:
    1.Connects to NotifManager.java
Note:
    1. The application does not actually collect users emails or personal info
        so the email notif currently works in a similar nature as SMSNotif. With
        more time it could be further developed to send actual emails
 */
package MainClasses;

public class EmailNotif {
    public static String sendEmail(String subject, String body) {
        return "EMAIL ALERT\nSubject: " + subject + "\nMessage: " + body;
    }
}
