package com.doddanna.NotificationSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditInfo {
    private long createdAt;
    private long updatedAt;
    private String createdBy;
    private String updatedBy;
}
