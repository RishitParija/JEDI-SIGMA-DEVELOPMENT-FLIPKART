package com.flipfit.business;

import com.flipfit.dao.NotificationDAO;
import com.flipfit.dao.NotificationDAOImpl;
import java.util.List;
import java.util.UUID;

/// Classs level Comminting

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationServiceImpl.
 *
 * @author Rishit
 * @ClassName "NotificationServiceImpl"
 */
public class NotificationServiceImpl implements NotificationService {

    private NotificationDAO notificationDAO = new NotificationDAOImpl();

    // MEthod level Commenting

    /**
     * Send notification.
     *
     * @param userId  the user id
     * @param message the message
     */
    @Override
    public void sendNotification(String userId, String message) {
        notificationDAO.addNotification(UUID.randomUUID().toString(), userId, message, "USER", "SENT");
    }

    // MEthod level Commenting

    /**
     * Gets the notifications.
     *
     * @param userId the user id
     * @return the notifications
     */
    @Override
    public List<String> getNotifications(String userId) {
        return notificationDAO.getNotificationsByUserId(userId);
    }
}