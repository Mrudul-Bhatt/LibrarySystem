package com.example.LibrarySystem.HotelManagementSystem.System3.Address_Account;

import com.example.LibrarySystem.HotelManagementSystem.System3.Enums.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Account {
    private String id;
    private String password;
    private AccountStatus status;

    public boolean resetPassword() {
        return false;
    }
}
