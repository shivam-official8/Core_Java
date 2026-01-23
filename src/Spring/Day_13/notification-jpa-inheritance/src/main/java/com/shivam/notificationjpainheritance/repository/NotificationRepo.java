package com.shivam.notificationjpainheritance.repository;

import com.shivam.notificationjpainheritance.entity.Notification;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {
}
