/*
Job: Handle user authentication and session management
Task breakdown:
    1.registers users
    2.Logs in users
    3.Tracks sessions
    4.Checks authentication
    5.Logging out users
Connections:
    1.UserDAO.java
    2.EncryptionUtils
 */

package MainClasses;

import dao.UserDAO;
import model.User;
import util.EncryptionUtils; // Rename Encrypt.java to this
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AuthManager {

    private static Set<String> activeSessions = new HashSet<>();
    public static int currentUserID;

    public static String login(String username, String password) {
        try {
            UserDAO userDao = new UserDAO();
            User user = userDao.getUserByUsername(username);

            if (user != null && EncryptionUtils.verifyPassword(password, user.getPasswordHash())) {
                String sessionId = UUID.randomUUID().toString();
                activeSessions.add(sessionId);
                currentUserID = user.getId();
                return sessionId;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Logging or handle better
        }

        return null;
    }



    public static boolean register(String username, String password) {
        try {
            UserDAO userDao = new UserDAO();
            String hashed = EncryptionUtils.hashPassword(password);

            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPasswordHash(hashed);
            newUser.setRole("user"); // default role

            return userDao.addUser(newUser); // You need to implement addUser in UserDAO
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isAuthenticated(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public static void logout(String sessionId) {
        activeSessions.remove(sessionId);
    }
}

