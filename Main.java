/*
Job: The entry point of the application
Task breakdown:
    1.Interacts with user to handle login/ registration and accept the file report for incident report
    2.Triggers the processing pipeline
Connection:
    1. Takes user input and calls appropriate methods in AuthManager.java
    2.Passes the file path to FileIncidentProcessor.java
 */

package MainClasses;

import dao.UserDAO;
import model.User;
import util.EncryptionUtils;


public class Main {
    public static boolean run(String username, String password, String filePath, boolean isLogin) {
        UserDAO userDao = new UserDAO();

        try {
            if (isLogin) {
                // Attempt login
                User user = userDao.getUserByUsername(username);
                if (user != null && user.getPasswordHash().equals(EncryptionUtils.hashPassword(password))) {
                    AuthManager.currentUserID = user.getId();
                    AuthManager.login(username, password); // Optional session ID
                    FileIncidentProcessor.processFile(filePath);
                    return true;
                } else {
                    System.out.println("Invalid credentials.");
                    return false;
                }
            } else {
                // Attempt registration
                User newUser = new User();
                newUser.setUsername(username);
                newUser.setPasswordHash(EncryptionUtils.hashPassword(password));
                newUser.setRole("user");

                boolean success = userDao.addUser(newUser);
                if (success) {
                    User user = userDao.getUserByUsername(username);
                    AuthManager.currentUserID = user.getId();
                    AuthManager.login(username, password); // Optional session ID
                    FileIncidentProcessor.processFile(filePath);
                    return true;
                } else {
                    System.out.println("Registration failed.");
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
