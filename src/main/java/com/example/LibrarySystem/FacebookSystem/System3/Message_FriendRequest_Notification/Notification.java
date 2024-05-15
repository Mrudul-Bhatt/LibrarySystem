package com.example.LibrarySystem.FacebookSystem.System3.Message_FriendRequest_Notification;

import com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin.Account;
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

    public boolean sendNotification(Account account);
}
