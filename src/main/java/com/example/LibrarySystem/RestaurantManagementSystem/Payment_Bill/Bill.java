package com.example.LibrarySystem.RestaurantManagementSystem.Payment_Bill;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bill {
    private int billId;
    private float amount;
    private float tip;
    private float tax;
    private boolean isPaid;

    public boolean generateBill();
}
