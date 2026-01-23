package com.shivam.notificationjpainheritance.controller;

import com.shivam.notificationjpainheritance.entity.EmailNotification;
import com.shivam.notificationjpainheritance.entity.Notification;
import com.shivam.notificationjpainheritance.entity.SMSNotification;
import com.shivam.notificationjpainheritance.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    NotificationService service;
    @PostMapping("/addsms")
    public void addSMS(@RequestBody SMSNotification smsNotification){
        service.addSMSNotification(smsNotification);
    }

    @PostMapping("/addemail")
    public void addEmailNotification(@RequestBody EmailNotification emailNotification){
        service.addEmailNotification(emailNotification);
    }

    @GetMapping("/getnotification")
    public List<Notification>  getAllNotification(){
        return service.getAllNotification();
    }
}
