package com.example.eventbot.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Alexander Iablonski
 */

@Entity
@Table(name = "event_cash")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventNotificationCashEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "serial")
    long id;
    @Column(name = "time")
    Date date;
    @Column(name = "description")
    String description;
    @Column(name = "user_id")
    long userId;

    public EventNotificationCashEntity(){}

    public static EventNotificationCashEntity eventTo(Date date, String description, long userId){
        EventNotificationCashEntity eventNotificationCashEntity = new EventNotificationCashEntity();
        eventNotificationCashEntity.setDate(date);
        eventNotificationCashEntity.setDescription(description);
        eventNotificationCashEntity.setUserId(userId);
        return eventNotificationCashEntity;
    }


}
