package com.doddanna.NotificationSystem.service;

import com.doddanna.NotificationSystem.enums.NotificationOperationType;
import com.doddanna.NotificationSystem.enums.NotificationRequestStatus;
import com.doddanna.NotificationSystem.enums.NotificationStatus;
import com.doddanna.NotificationSystem.models.Notification;
import com.doddanna.NotificationSystem.models.NotificationRequest;
import com.doddanna.NotificationSystem.repository.NotificationRepository;
import com.doddanna.NotificationSystem.repository.NotificationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NotificationGroupService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    NotificationProcessService notificationProcessService;

    @Autowired
    NotificationRequestRepository notificationRequestRepository;

    public String processNotification(NotificationRequest notificationRequest){
        List<String> emails = notificationRequest.getEmails();
        List<NotificationOperationType> notificationOperationTypes = notificationRequest.getNotificationOperationTypes();
        String templateId = getTemplateId(notificationOperationTypes);
        //mocking the data purpose, client status is accepted
        notificationRequest.setStatus(notificationRequest.getStatus()!=null?notificationRequest.getStatus():NotificationRequestStatus.IN_QUEUE);
        NotificationRequest save = notificationRequestRepository.save(notificationRequest);
        String id = save.getId();
        List<Notification> collect = emails.stream().map(email -> Notification
                .builder()
                .notificationRequestId(id)
                .recipient(email)
                .templateId(templateId)
                .status(NotificationStatus.IN_PROGRESS)
                .build()).collect(Collectors.toList());
        notificationRepository.saveAll(collect);
        //send to actual
        notificationProcessService.sendNotifications(collect);
        return id;
    }

    private String getTemplateId(List<NotificationOperationType> notificationOperationTypes){
        //validate and get the template id
        return UUID.randomUUID().toString();
    }

    public List<NotificationRequest> getNotificationRequestByStatus(NotificationRequestStatus status){
        return notificationRequestRepository.findAllByStatus(status);
    }




}
