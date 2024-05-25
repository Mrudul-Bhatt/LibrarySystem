package com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger;

import com.example.LibrarySystem.AirlineManagementSystem.System2.DesignPatterns.Observer.Observer;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Passenger implements Observer {
    private int passengerId;
    private String name;
    private String gender;
    private Date dateOfBirth;
    private String passportNumber;

    @Override
    public void update(String message) {
        System.out.println("Notification for Passenger " + name + ": " + message);
    }
}
