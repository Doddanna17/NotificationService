package com.doddanna.NotificationSystem.repository;

import com.doddanna.NotificationSystem.enums.NotificationRequestStatus;
import com.doddanna.NotificationSystem.models.NotificationRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRequestRepository extends MongoRepository<NotificationRequest, String> {
    List<NotificationRequest> findAllByStatus(NotificationRequestStatus status);
}
