/*
Job: Logs security audit events
Task breakdown:
    1.Logs security events
Connection:
    1. Might be triggered by login attempts or other critical actions in AuthManager.java
 */

package MainClasses;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class SecurityAuditLogger {
    private static final String LOG_FILE = "security_audit.log";

    public static void log(String action, String username){
        String timestamp = LocalDateTime.now().toString();
        String logEntry = String.format("[%s] User: %s | Action: %s%n", timestamp, username, action);

        try(FileWriter writer = new FileWriter(LOG_FILE, true)){
            writer.write(logEntry);
        }catch(IOException e){
            System.err.println("Failed to write to security audit log: "+ e.getMessage());
        }
    }
}

