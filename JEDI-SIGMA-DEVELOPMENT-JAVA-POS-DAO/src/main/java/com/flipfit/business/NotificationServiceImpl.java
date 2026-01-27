package com.flipfit.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationServiceImpl implements NotificationService {

    // Static map to persist notifications across service instances (Mock DB)
    private static Map<String, List<String>> userNotifications = new HashMap<>();

    @Override
    public void sendNotification(String userId, String message) {
        userNotifications.computeIfAbsent(userId, k -> new ArrayList<>()).add(message);
        System.out.println("Notification sent to " + userId + ": " + message);
    }

    @Override
    public List<String> getNotifications(String userId) {
        return userNotifications.getOrDefault(userId, new ArrayList<>());
    }
}