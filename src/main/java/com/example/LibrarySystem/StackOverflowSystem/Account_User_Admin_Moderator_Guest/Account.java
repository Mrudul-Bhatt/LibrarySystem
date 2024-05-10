package com.example.LibrarySystem.StackOverflowSystem.Account_User_Admin_Moderator_Guest;

import com.example.LibrarySystem.StackOverflowSystem.Enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Account {
    private String accountId;
    private String username;
    private String password;
    private String name;
    private String email;
    private int phone;
    private AccountStatus status;
}
