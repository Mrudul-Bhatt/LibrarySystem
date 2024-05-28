package com.example.LibrarySystem.A_ParkingLotSystem.System3.Account_Admin_ParkingAttendant;

import com.example.LibrarySystem.A_ParkingLotSystem.System3.Enums.AccountStatus;
import com.example.LibrarySystem.A_ParkingLotSystem.System3.Person_Address.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Account {
    private String userName;
    private String password;
    private Person person; // Refers to an instance of the Person class
    private AccountStatus status; // Refers to the AccountStatus enum
}
