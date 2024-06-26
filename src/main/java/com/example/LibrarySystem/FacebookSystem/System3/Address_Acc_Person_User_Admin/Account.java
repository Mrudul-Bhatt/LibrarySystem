package com.example.LibrarySystem.FacebookSystem.System3.Address_Acc_Person_User_Admin;

import com.example.LibrarySystem.FacebookSystem.System3.Enums.AccountStatus;

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

}
