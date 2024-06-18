package com.doddanna.NotificationSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping("/health-status")
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }
}
