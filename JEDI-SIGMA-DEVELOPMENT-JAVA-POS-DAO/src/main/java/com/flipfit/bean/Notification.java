package com.flipfit.bean;

import java.time.LocalDateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class Notification.
 *
 * @author Rishit
 * @ClassName "Notification"
 */
public class Notification {
    private String notificationId;
    private String message;
    private LocalDateTime sentAt;
    private String type;
    private String status;

    /**
     * Gets the notification id.
     *
     * @return the notification id
     */
    public String getNotificationId() {
        return notificationId;
    }

    /**
     * Sets the notification id.
     *
     * @param notificationId the new notification id
     */
    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the sent at.
     *
     * @return the sent at
     */
    public LocalDateTime getSentAt() {
        return sentAt;
    }

    /**
     * Sets the sent at.
     *
     * @param sentAt the new sent at
     */
    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}