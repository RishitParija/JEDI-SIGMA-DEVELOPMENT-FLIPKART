package com.flipfit.business;

public class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendNotification(String userId, String message) {
        System.out.println("Notification sent to " + userId + ": " + message);
    }
}