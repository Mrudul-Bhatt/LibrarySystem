package com.example.LibrarySystem.LinkedinSystem.System3.Search_Catalog_Notification;

import com.example.LibrarySystem.LinkedinSystem.System3.Account_Address.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    // This class can be used to send notifications to users in Observer pattern, currently we are only sending string
    // messages
    public boolean sendNotification(Account account) {
        return true;
    }
}
