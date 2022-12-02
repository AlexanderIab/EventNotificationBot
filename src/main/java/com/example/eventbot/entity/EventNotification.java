package com.example.eventbot.entity;

import com.example.eventbot.model.NotificationFrequency;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Alexander Iablonski
 */

@Entity
@Table(name = "user_events")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", columnDefinition = "serial")
    int eventId;

    @Column(name = "time")
    @NotNull(message = "Date required")
    Date date;

    @Column(name = "description")
    @Size(min = 2, max = 200, message = "Description up to 200 characters")
    String description;

    @Column(name = "event_freq", columnDefinition = "TIME")
    @Enumerated(EnumType.STRING)
    NotificationFrequency notificationFrequency;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    public EventNotification() {
    }

    public EventNotification(int eventId, @NotNull(message = "Date required") Date date, @Size(min = 2, max = 200, message = "Description up to 200 characters")
    String description, NotificationFrequency notificationFrequency, User user) {
        this.eventId = eventId;
        this.date = date;
        this.description = description;
        this.notificationFrequency = notificationFrequency;
        this.user = user;
    }
}
