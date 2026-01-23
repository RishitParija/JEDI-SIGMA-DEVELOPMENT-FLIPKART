package com.flipfit.bean;

public class GymOwner extends User {
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


    public String getPanCard() { return panCard; }
    public Boolean getIsVerified() { return isVerified; }
    public void setIsVerified(Boolean isVerified) { this.isVerified = isVerified; }
}
