package com.example.LibrarySystem.RestaurantManagementSystem.Payment_Bill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cash extends Payment {
    private double cashTendered;

    public void initiateTransaction() {
        // functionality
    }
}
