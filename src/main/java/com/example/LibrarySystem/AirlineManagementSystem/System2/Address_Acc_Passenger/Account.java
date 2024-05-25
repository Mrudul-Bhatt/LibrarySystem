package com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.AccountStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private AccountStatus status;
    private int accountId;
    private String username;
    private String password;
}
