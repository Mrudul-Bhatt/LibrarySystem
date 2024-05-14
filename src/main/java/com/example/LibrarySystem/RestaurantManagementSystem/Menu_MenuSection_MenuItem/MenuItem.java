package com.example.LibrarySystem.RestaurantManagementSystem.Menu_MenuSection_MenuItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuItem {
    private int menuItemID;
    private String title;
    private String description;
    private double price;

    public boolean updatePrice(double price) {
        if (price < 0) {
            return false; // Price cannot be negative
        }
        this.price = price;
        return true;
    }
}
