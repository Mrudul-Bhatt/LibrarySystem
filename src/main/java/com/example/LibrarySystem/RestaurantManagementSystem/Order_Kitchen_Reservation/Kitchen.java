package com.example.LibrarySystem.RestaurantManagementSystem.Order_Kitchen_Reservation;

import com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee.Chef;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Kitchen {
    private String name;
    private Chef[] chefs;

    public boolean assignChef(Chef chef) {
        if (chef == null) {
            return false; // Cannot assign null chef
        }
        // Check if there are available slots for chefs
        for (int i = 0; i < chefs.length; i++) {
            if (chefs[i] == null) {
                chefs[i] = chef;
                return true; // Chef assigned successfully
            }
        }
        return false; // All chef slots are occupied
    }
}
