package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Account_Admin_Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private int zipCode;
    private String address;
    private String city;
    private String state;
    private String country;
}
