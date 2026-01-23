package com.shivam.notificationjpainheritance.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("SMS")
@Data
public class SMSNotification extends Notification{
    private String phoneNumber;
}
