package com.flipfit.business;

public class NotificationServiceImpl implements NotificationService {
    @Override
    public void send(){
        System.out.println("Notification was sent");
    }
}