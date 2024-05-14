package com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Customer extends Person {
    private Date lastVisitedDate;

    public Customer(String name, String email, String phone) {
        super(name, email, phone);
    }
}
