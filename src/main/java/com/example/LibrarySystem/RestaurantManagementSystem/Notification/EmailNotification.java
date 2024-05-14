package com.example.LibrarySystem.RestaurantManagementSystem.Notification;

import com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailNotification extends Notification {
    private String email;

    public void sendNotification(Person person) {
        // functionality
    }
}
