package com.shivam.notificationjpainheritance.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("EMAIL")
@Data
public class EmailNotification extends Notification {
    private String emailId;
}
