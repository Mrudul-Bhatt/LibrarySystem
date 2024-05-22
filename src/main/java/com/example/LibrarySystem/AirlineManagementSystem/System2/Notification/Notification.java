package com.example.LibrarySystem.AirlineManagementSystem.System2.Notification;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Account;

import java.util.Date;

public class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public void sendNotification(Account account);
}
