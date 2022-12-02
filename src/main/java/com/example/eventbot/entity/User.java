package com.example.eventbot.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.List;

/**
 * @author Alexander Iablonski
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @Column(name = "id")
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "time_zone", columnDefinition = "default 0")
    int timeZone;

    @OneToMany(mappedBy = "user")
    List<EventNotification> eventNotificationList;

    @Column(name = "on_off")
    boolean NotificationSendStatus;

    public User() {
    }
}
