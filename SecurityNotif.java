/*
Job: Sends security-related notification
Task breakdown:
    1.Sends notifications when a suspicious or unauthorized action is detected
Connection:
    1. Could be triggered by AuthManager.java for failed login attempts or other abnormal secuirty events
 */
package MainClasses;


public abstract class SecurityNotif {
    protected String message;

    public SecurityNotif(String message){
        this.message = message;
    }

    public abstract void send();
}
