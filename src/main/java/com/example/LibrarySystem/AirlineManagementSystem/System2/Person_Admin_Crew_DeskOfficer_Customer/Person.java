package com.example.LibrarySystem.AirlineManagementSystem.System2.Person_Admin_Crew_DeskOfficer_Customer;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Account;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Person {
    private String name;
    private Address address;
    private String email;
    private String phone;
    private Account account;
}
