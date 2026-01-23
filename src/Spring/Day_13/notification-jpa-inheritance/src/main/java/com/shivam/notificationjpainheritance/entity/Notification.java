package com.shivam.notificationjpainheritance.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "notification_type")
@Table(
        name = "notification",
        indexes = {
                @Index(name = "idx_notification_status", columnList = "status")
        }
)
@Data
public abstract class Notification {
    @Id
    @GeneratedValue
    private Long id;

    private String message;
    private String status;
}
