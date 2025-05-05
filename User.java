/*
Job: Represents a user in the system
Task breakdown:
    1.Stores user details like username, passwordHash, role, etc.
Connection:
    1. Used by AuthManager.java for managing user login, registration, and session tracking
    2.Stored and retrieved in/from the database by UserDAO.java
 */
package model;

public class User {
    private int id;
    private String username;
    private String passwordHash;
    private String role;

    //Getters

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getPasswordHash() {
        return passwordHash;

    }

    public int getId() {
        return id;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String passwordHash) {

    }

    public void setRole(String role) {
    }

}

