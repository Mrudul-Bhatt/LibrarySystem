package com.example.LibrarySystem.StockBrokerageSystem.System3.Notification;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class Notification {
    private String notificationId;
    private Date creationDate;
    private String content;

    public boolean sendNotification();
}
