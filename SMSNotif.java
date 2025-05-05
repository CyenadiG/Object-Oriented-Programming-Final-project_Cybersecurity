/*
Job: Creates message for high or critical severities
Task breakdown:
    1. Sends a SMS message to user about
Connection:
    1.Connects to NotifManager.java
Note:
    1. The application does not actually collect users emails or personal info
        so the email notif currently works in a similar nature as SMSNotif. With
        more time it could be further developed to send actual emails
 */

package MainClasses;

public class SMSNotif {
    public static String sendSMS(String message) {
        return "SMS ALERT\nMessage: " + message;
    }
}