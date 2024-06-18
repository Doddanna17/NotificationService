package com.doddanna.NotificationSystem.repository;

import com.doddanna.NotificationSystem.enums.NotificationStatus;
import com.doddanna.NotificationSystem.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,String> {

    List<Notification> findAllByNotificationRequestId(String notificationRequestId);

    List<Notification> findAllByStatus(NotificationStatus status);
}
