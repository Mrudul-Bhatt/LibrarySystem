package com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Person {
    private String name;
    private String email;
    private String phone;
}
