package com.flipfit.dao;

import java.util.List;

/**
 * The Interface NotificationDAO.
 *
 * @author Rishit
 * @ClassName "NotificationDAO"
 */
public interface NotificationDAO {
    /**
     * Adds the notification.
     *
     * @param notificationId the notification ID
     * @param userId         the user ID
     * @param message        the message
     * @param type           the type
     * @param status         the status
     */
    void addNotification(String notificationId, String userId, String message, String type, String status);

    /**
     * Gets notifications by user id.
     *
     * @param userId the user ID
     * @return the notifications by user id
     */
    List<String> getNotificationsByUserId(String userId);
}
