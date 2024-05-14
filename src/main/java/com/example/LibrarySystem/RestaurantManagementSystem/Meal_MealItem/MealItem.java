package com.example.LibrarySystem.RestaurantManagementSystem.Meal_MealItem;

import com.example.LibrarySystem.RestaurantManagementSystem.Menu_MenuSection_MenuItem.MenuItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MealItem {
    private int mealItemID;
    private int quantity;
    private MenuItem menuItem;

    public boolean updateQuantity(int quantity) {
        if (quantity < 0) {
            return false; // Quantity cannot be negative
        }
        this.quantity = quantity;
        return true;
    }
}
