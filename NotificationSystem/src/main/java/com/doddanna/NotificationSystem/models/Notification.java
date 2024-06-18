package com.doddanna.NotificationSystem.models;

import com.doddanna.NotificationSystem.enums.NotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Notification extends AuditInfo {

    @Id
    private String id;

    private String recipient;
    private String notificationRequestId;
    private String templateId;
    private NotificationStatus status;
}
