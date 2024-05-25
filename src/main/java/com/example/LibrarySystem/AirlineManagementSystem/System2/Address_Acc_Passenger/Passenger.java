package com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passenger {
    private int passengerId;
    private String name;
    private String gender;
    private Date dateOfBirth;
    private String passportNumber;
}
