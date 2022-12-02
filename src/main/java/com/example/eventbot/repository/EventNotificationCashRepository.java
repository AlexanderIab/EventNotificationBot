package com.example.eventbot.repository;

import com.example.eventbot.entity.EventNotificationCashEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventNotificationCashRepository extends JpaRepository <EventNotificationCashEntity, Long> {
    EventNotificationCashEntity findById(long id);
}
