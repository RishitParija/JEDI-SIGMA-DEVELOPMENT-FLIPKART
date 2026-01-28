package com.flipfit.dao;

import com.flipfit.util.DBConnection;
import com.flipfit.constants.SQLConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class NotificationDAOImpl.
 *
 * @author Rishit
 * @ClassName "NotificationDAOImpl"
 */
public class NotificationDAOImpl implements NotificationDAO {

    /**
     * Adds the notification.
     *
     * @param notificationId the notification ID
     * @param userId         the user ID
     * @param message        the message
     * @param type           the type
     * @param status         the status
     */
    @Override
    public void addNotification(String notificationId, String userId, String message, String type, String status) {
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.ADD_NOTIFICATION_QUERY)) {
            stmt.setString(1, notificationId);
            stmt.setString(2, userId);
            stmt.setString(3, message);
            stmt.setString(4, type);
            stmt.setString(5, status);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                // Success - we'll keep it silent for the user but we know it worked.
            }
        } catch (SQLException e) {
            System.err.println(
                    "CRITICAL: Failed to add notification to DB for user " + userId + ". Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Gets notifications by user id.
     *
     * @param userId the user ID
     * @return the notifications by user id
     */
    @Override
    public List<String> getNotificationsByUserId(String userId) {
        List<String> notifications = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQLConstants.GET_NOTIFICATIONS_QUERY)) {
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                notifications.add(rs.getString("message"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifications;
    }
}
