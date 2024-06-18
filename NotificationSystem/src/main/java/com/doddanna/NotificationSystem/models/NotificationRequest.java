package com.doddanna.NotificationSystem.models;

import com.doddanna.NotificationSystem.enums.NotificationOperationType;
import com.doddanna.NotificationSystem.enums.NotificationRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class NotificationRequest{
    @Id
    private String id;

    private List<String> emails;
    private List<NotificationOperationType> notificationOperationTypes;
    private NotificationRequestStatus status;

    private long createdAt;
    private long updatedAt;
    private String createdBy;
    private String updatedBy;

}
