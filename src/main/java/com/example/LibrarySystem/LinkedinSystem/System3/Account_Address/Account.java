package com.example.LibrarySystem.LinkedinSystem.System3.Account_Address;

import com.example.LibrarySystem.LinkedinSystem.System3.Enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private String accountId;
    private String password;
    private String username;
    private String email;
    private AccountStatus status;
}
