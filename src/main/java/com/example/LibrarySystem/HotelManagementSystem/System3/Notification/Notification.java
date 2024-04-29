package com.example.LibrarySystem.HotelManagementSystem.System3.Notification;

import com.example.LibrarySystem.HotelManagementSystem.System3.Person_PersonTypes.Person;

import java.util.Date;

public abstract class Notification {
    private int notificationId;
    // The Date data type represents and deals with both date and time.
    private Date createdOn;
    private String content;

    public abstract void sendNotification(Person person);
}
