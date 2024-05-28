package com.example.LibrarySystem.A_ParkingLotSystem.System3.Person_Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private int zipCode;
    private String address;
    private String city;
    private String state;
    private String country;
}
