package com.example.LibrarySystem.RestaurantManagementSystem.Payment_Bill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard extends Payment {
    private String nameOnCard;
    private int zipcode;

    public void initiateTransaction() {
        // functionality
    }
}
