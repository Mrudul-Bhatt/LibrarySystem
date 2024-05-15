package com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private int zipCode;
    private String houseNo;
    private String city;
    private String state;
    private String country;
}
