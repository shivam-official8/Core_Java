package com.shivam.notificationjpainheritance.service;

import com.shivam.notificationjpainheritance.entity.EmailNotification;
import com.shivam.notificationjpainheritance.entity.Notification;
import com.shivam.notificationjpainheritance.entity.SMSNotification;
import com.shivam.notificationjpainheritance.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationRepo notificationRepo;

    public void addSMSNotification(SMSNotification smsNotification){
        notificationRepo.save(smsNotification);
    }
    public void addEmailNotification(EmailNotification emailNotification){
        notificationRepo.save(emailNotification);
    }

    public List<Notification> getAllNotification() {
        return notificationRepo.findAll();
    }
}
