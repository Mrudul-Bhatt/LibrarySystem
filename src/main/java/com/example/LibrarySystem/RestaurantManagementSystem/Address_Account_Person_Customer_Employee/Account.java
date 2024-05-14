package com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee;

import com.example.LibrarySystem.RestaurantManagementSystem.Enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Account {
    private String accountId;
    private String password;
    private Address address;
    private AccountStatus status;
}
