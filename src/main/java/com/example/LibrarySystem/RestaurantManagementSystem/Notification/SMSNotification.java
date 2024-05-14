package com.example.LibrarySystem.RestaurantManagementSystem.Notification;

import com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SMSNotification extends Notification {
    private String phone;

    public void sendNotification(Person person) {
        // functionality
    }
}
