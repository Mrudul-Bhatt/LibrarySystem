package com.example.LibrarySystem.LinkedinSystem.System3.Person_Admin_User;

import com.example.LibrarySystem.LinkedinSystem.System3.Account_Address.Account;
import com.example.LibrarySystem.LinkedinSystem.System3.Account_Address.Address;
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
