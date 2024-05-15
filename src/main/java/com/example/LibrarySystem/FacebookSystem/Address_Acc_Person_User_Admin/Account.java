package com.example.LibrarySystem.FacebookSystem.Address_Acc_Person_User_Admin;

import com.example.LibrarySystem.RestaurantManagementSystem.Enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Account {
    private String accountId;
    private String password;
    private String username;
    private String email;
    private AccountStatus status;

    public boolean resetPassword();
}
