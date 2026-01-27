package com.flipfit.business;

public interface NotificationService {
    void sendNotification(String userId, String message);

    java.util.List<String> getNotifications(String userId);
}