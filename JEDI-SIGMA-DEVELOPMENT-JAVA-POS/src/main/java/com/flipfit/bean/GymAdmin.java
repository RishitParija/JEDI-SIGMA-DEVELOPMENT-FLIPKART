package com.flipfit.bean;

public class GymAdmin implements User {
    private String userId;
    private String name;
    private String email;
    private String passwordHash;
    private String employeeId;

    public GymAdmin(String userId, String name, String email, String passwordHash, String employeeId) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.employeeId = employeeId;
    }

    @Override
    public String getUserId() { return userId; }
    @Override
    public void setUserId(String userId) { this.userId = userId; }
    @Override
    public String getName() { return name; }
    @Override
    public String getEmail() { return email; }
    @Override
    public String getPasswordHash() { return passwordHash; }
    @Override
    public String getRole() { return "GYM_ADMIN"; }

    @Override
    public void login() { System.out.println("Admin " + name + " logged in."); }
    @Override
    public void logout() { System.out.println("Admin " + name + " logged out."); }
}
