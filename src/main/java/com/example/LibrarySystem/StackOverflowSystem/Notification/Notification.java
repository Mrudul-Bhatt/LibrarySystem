package com.example.LibrarySystem.StackOverflowSystem.Notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    // public boolean sendNotification(Account account);
}
