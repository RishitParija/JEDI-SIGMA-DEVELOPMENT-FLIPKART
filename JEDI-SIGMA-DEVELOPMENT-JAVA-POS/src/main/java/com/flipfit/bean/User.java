package com.flipfit.bean;

public interface User {
    String getUserId();
    void setUserId(String userId);
    String getName();
    String getEmail();
    String getPasswordHash();
    String getRole(); // Changed from Enum to String

    void login();
    void logout();
}