package com.flipfit.dao;

import java.util.List;

/// Class level Commenting

// TODO: Auto-generated Javadoc
/**
 * The Interface NotificationDAO.
 *
 * @author Rishit
 * @ClassName "NotificationDAO"
 */
public interface NotificationDAO {

    // Method level Commenting

    /**
     * Adds the notification.
     *
     * @param notificationId the notification id
     * @param userId         the user id
     * @param message        the message
     * @param type           the type
     * @param status         the status
     */
    void addNotification(String notificationId, String userId, String message, String type, String status);

    // Method level Commenting

    /**
     * Gets notifications by user id.
     *
     * @param userId the user id
     * @return the notifications by user id
     */
    List<String> getNotificationsByUserId(String userId);
}
