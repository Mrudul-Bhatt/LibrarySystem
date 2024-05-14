package com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Employee extends Person {
    private String name;
    private String email;
    private String phone;

    public Employee(String name, String email, String phone) {
        super(name, email, phone);
    }
}
