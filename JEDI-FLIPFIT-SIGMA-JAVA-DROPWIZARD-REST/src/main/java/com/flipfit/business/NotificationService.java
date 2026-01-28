package com.flipfit.business;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface NotificationService.
 *
 * @author Rishit
 * @ClassName "NotificationService"
 */
public interface NotificationService {
    // Method level Commenting

    /**
     * Send notification.
     *
     * @param userId  the user id
     * @param message the message
     */
    void sendNotification(String userId, String message);

    // Method level Commenting

    /**
     * Gets the notifications.
     *
     * @param userId the user id
     * @return the notifications
     */
    java.util.List<String> getNotifications(String userId);
}