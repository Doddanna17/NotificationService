package com.doddanna.NotificationSystem.controller;

import com.doddanna.NotificationSystem.enums.NotificationRequestStatus;
import com.doddanna.NotificationSystem.models.NotificationRequest;
import com.doddanna.NotificationSystem.service.NotificationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processing")
public class NotificationController {


    @Autowired
    NotificationGroupService notificationGroupService;

    //Can be handled with common response object which can be standersed across the app
    @PostMapping
    public ResponseEntity<String> saveNotification(@RequestBody NotificationRequest notificationRequest){
        String id = notificationGroupService.processNotification(notificationRequest);
        return new ResponseEntity<>(id, HttpStatus.ACCEPTED);
    }

    @RequestMapping("/{status}")
    public ResponseEntity<List<NotificationRequest>> getNotificationRequestsStatus(@PathVariable("status")NotificationRequestStatus status){
        return new ResponseEntity<>(notificationGroupService.getNotificationRequestByStatus(status),HttpStatus.OK);
    }
}
