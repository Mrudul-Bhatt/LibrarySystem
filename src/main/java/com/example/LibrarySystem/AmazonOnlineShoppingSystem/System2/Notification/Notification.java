package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Notification;

import java.util.Date;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Account_Admin_Customer.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public abstract boolean sendNotification(Account account);
}
