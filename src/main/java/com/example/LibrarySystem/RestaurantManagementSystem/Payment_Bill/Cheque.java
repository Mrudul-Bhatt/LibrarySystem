package com.example.LibrarySystem.RestaurantManagementSystem.Payment_Bill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cheque extends Payment {
    private String bankName;
    private String checkNumber;

    public void initiateTransaction() {
        // functionality
    }
}
