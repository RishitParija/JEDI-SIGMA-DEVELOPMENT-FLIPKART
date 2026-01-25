package com.flipfit.bean;

public class GymOwner extends User {
    private String panCard;
    private Boolean isVerified;

    public GymOwner(String userId, String username, String name, String email, String passwordHash, String panCard) {
        this.setUserId(userId);
        this.setUsername(username);
        this.setName(name);
        this.setEmail(email);
        this.setHashedPassword(passwordHash);
        this.panCard = panCard;
        this.isVerified = false;
    }

    public String getPanCard() {
        return panCard;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }
}
