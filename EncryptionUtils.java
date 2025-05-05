/*
Job: Secucrely handle password operations
Task breakdown:
    1.Hashing passwords when users register (using SHA-256)
    2.Verifying passwords during user login
Connections:
    1.UserDAO.java stores the passwords
    2.AuthManager.java calls EncryptionUtils
 */
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class EncryptionUtils {
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b)); // hex format
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing error", e);
        }
    }

    public static boolean verifyPassword(String password, String hashed) {
        return hashPassword(password).equals(hashed);
    }
}
