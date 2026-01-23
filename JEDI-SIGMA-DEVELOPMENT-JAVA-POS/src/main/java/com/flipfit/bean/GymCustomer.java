package com.flipfit.bean;

public class GymCustomer implements User {
    private String userId;
    private String name;
    private String email;
    private String passwordHash;
    private Double walletBalance;

    public GymCustomer(String userId, String name, String email, String passwordHash, Double walletBalance) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.walletBalance = walletBalance;
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
    public String getRole() { return "GYM_CUSTOMER"; }

    @Override
    public void login() { System.out.println("Customer " + name + " logged in."); }
    @Override
    public void logout() { System.out.println("Customer " + name + " logged out."); }

    public Double getWalletBalance() { return walletBalance; }
    public void setWalletBalance(Double walletBalance) { this.walletBalance = walletBalance; }
}
