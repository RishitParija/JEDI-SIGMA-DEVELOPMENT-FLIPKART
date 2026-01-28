package com.flipfit.business;

import com.flipfit.dao.NotificationDAO;
import com.flipfit.dao.NotificationDAOImpl;
import java.util.List;
import java.util.UUID;

/**
 * The Class NotificationServiceImpl.
 *
 * @author Rishit
 * @ClassName "NotificationServiceImpl"
 */
public class NotificationServiceImpl implements NotificationService {

    private NotificationDAO notificationDAO = new NotificationDAOImpl();

    /**
     * Send notification.
     *
     * @param userId  the user ID
     * @param message the message
     */
    @Override
    public void sendNotification(String userId, String message) {
        notificationDAO.addNotification(UUID.randomUUID().toString(), userId, message, "USER", "SENT");
    }

    /**
     * Gets the notifications.
     *
     * @param userId the user ID
     * @return the notifications
     */
    @Override
    public List<String> getNotifications(String userId) {
        return notificationDAO.getNotificationsByUserId(userId);
    }
}