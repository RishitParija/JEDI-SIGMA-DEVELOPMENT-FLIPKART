package com.flipfit.bean;

public class GymCustomer extends User {
    private Double walletBalance;

    public GymCustomer(String userId, String username, String name, String email, String passwordHash,
            Double walletBalance) {
        this.setUserId(userId);
        this.setUsername(username);
        this.setName(name);
        this.setEmail(email);
        this.setHashedPassword(passwordHash);
        this.walletBalance = walletBalance;
    }

    public Double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }
}
