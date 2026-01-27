package com.flipfit.business;

// TODO: Auto-generated Javadoc
/**
 * The Interface NotificationService.
 *
 * @author Shravya
 * @ClassName "NotificationService"
 */
public interface NotificationService {
    /**
     * Send notification.
     *
     * @param userId  the user ID
     * @param message the message
     */
    void sendNotification(String userId, String message);

    /**
     * Gets the notifications.
     *
     * @param userId the user ID
     * @return the notifications
     */
    java.util.List<String> getNotifications(String userId);
}