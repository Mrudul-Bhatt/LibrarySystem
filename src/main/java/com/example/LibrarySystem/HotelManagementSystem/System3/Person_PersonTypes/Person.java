package com.example.LibrarySystem.HotelManagementSystem.System3.Person_PersonTypes;

import com.example.LibrarySystem.HotelManagementSystem.System3.Address_Account.Account;
import com.example.LibrarySystem.HotelManagementSystem.System3.Address_Account.Address;

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
