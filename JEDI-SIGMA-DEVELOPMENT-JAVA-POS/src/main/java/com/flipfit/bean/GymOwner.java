package com.flipfit.bean;

public class GymOwner implements User {
    private String userId;
    private String name;
    private String email;
    private String passwordHash;
    private String panCard;
    private Boolean isVerified;

    public GymOwner(String userId, String name, String email, String passwordHash, String panCard) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.panCard = panCard;
        this.isVerified = false;
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
    public String getRole() { return "GYM_OWNER"; }

    @Override
    public void login() { System.out.println("Owner " + name + " logged in."); }
    @Override
    public void logout() { System.out.println("Owner " + name + " logged out."); }

    public String getPanCard() { return panCard; }
    public Boolean getIsVerified() { return isVerified; }
    public void setIsVerified(Boolean isVerified) { this.isVerified = isVerified; }
}
