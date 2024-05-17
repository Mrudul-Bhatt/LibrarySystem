package com.example.LibrarySystem.StockBrokerageSystem.System3.Account_Member_Admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Address {
    private int zipCode;
    private String address;
    private String city;
    private String state;
    private String country;
}
