package com.doddanna.NotificationSystem.service;

import com.doddanna.NotificationSystem.models.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationProcessService {

    public void sendNotifications(List<Notification> notificationList){
        notificationList.stream().forEach(notification -> {
            System.out.println("Sending notification  : "+notification.getRecipient());
        });
    }
}
