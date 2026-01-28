package com.flipfit.business;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Interface NotificationService.
 *
 * @author Rishit
 * @ClassName "NotificationService"
 */
public interface NotificationService {
    // MEthod level Commenting

    /**
     * Send notification.
     *
     * @param userId  the user id
     * @param message the message
     */
    void sendNotification(String userId, String message);

    // MEthod level Commenting

    /**
     * Gets the notifications.
     *
     * @param userId the user id
     * @return the notifications
     */
    java.util.List<String> getNotifications(String userId);
}