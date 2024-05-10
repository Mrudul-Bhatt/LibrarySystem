package com.example.LibrarySystem.StackOverflowSystem.Notification;

import com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public boolean sendNotification(Account account);
}
