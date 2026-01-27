package com.flipfit.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationServiceImpl.
 *
 * @author Shravya
 * @ClassName "NotificationServiceImpl"
 */
public class NotificationServiceImpl implements NotificationService {

    // Static map to persist notifications across service instances (Mock DB)
    private static Map<String, List<String>> userNotifications = new HashMap<>();

    /**
     * Send notification.
     *
     * @param userId  the user ID
     * @param message the message
     */
    @Override
    public void sendNotification(String userId, String message) {
        userNotifications.computeIfAbsent(userId, k -> new ArrayList<>()).add(message);
        System.out.println("Notification sent to " + userId + ": " + message);
    }

    /**
     * Gets the notifications.
     *
     * @param userId the user ID
     * @return the notifications
     */
    @Override
    public List<String> getNotifications(String userId) {
        return userNotifications.getOrDefault(userId, new ArrayList<>());
    }
}