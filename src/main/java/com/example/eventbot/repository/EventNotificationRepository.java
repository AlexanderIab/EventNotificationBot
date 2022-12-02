package com.example.eventbot.repository;

import com.example.eventbot.entity.EventNotification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alexander Iablonski
 */

public interface EventNotificationRepository extends JpaRepository<EventNotification, Long> {
    EventNotification findByEventId(long id);
}
