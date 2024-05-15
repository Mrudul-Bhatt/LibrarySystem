package com.example.LibrarySystem.FacebookSystem.Address_Acc_Person_User_Admin;

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
