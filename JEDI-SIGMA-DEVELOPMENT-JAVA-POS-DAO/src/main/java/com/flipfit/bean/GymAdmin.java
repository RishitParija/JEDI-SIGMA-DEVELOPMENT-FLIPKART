package com.flipfit.bean;

public class GymAdmin extends User {
    private String employeeId;

    public GymAdmin(String userId, String username, String name, String email, String passwordHash, String employeeId) {
        this.setUserId(userId);
        this.setUsername(username);
        this.setName(name);
        this.setEmail(email);
        this.setHashedPassword(passwordHash);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
