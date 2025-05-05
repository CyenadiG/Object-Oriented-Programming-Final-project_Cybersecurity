package MainClasses;

import static com.sun.beans.introspect.PropertyInfo.Name.description;

public class SeverityClassifier {

    //method: Severity classify(Incident incident)
    public static String classify(String incidentDescription){
        String desc = incidentDescription.toLowerCase();

        if (desc.contains("data leak") || desc.contains("ransomware") || desc.contains("breach")) {
            return "Critical";
        } else if (desc.contains("phishing") || desc.contains("malware") || desc.contains("unauthorized")) {
            return "High";
        } else if (desc.contains("failed login") || desc.contains("suspicious")) {
            return "Medium";
        } else {
            return "Low";
        }
    }
}