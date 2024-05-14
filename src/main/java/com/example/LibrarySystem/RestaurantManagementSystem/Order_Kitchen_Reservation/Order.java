package com.example.LibrarySystem.RestaurantManagementSystem.Order_Kitchen_Reservation;

import com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee.Chef;
import com.example.LibrarySystem.RestaurantManagementSystem.Address_Account_Person_Customer_Employee.Waiter;
import com.example.LibrarySystem.RestaurantManagementSystem.Enums.OrderStatus;
import com.example.LibrarySystem.RestaurantManagementSystem.Meal_MealItem.Meal;
import com.example.LibrarySystem.RestaurantManagementSystem.Table_TableSeat.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private int OrderID;
    private OrderStatus status;
    private Date creationTime;
    private Meal[] meals;
    private Table table;
    private Waiter waiter;
    private Chef chef;

    public boolean addMeal(Meal meal) {
        if (meal == null) {
            return false; // Cannot add null meal
        }
        // Check if there are available slots for meals
        for (int i = 0; i < meals.length; i++) {
            if (meals[i] == null) {
                meals[i] = meal;
                return true; // Meal added successfully
            }
        }
        return false; // All meal slots are occupied
    }

    public boolean removeMeal(Meal meal) {
        if (meal == null) {
            return false; // Cannot remove null meal
        }
        // Search for the meal and remove it
        for (int i = 0; i < meals.length; i++) {
            if (meals[i] == meal) {
                meals[i] = null;
                return true; // Meal removed successfully
            }
        }
        return false; // Meal not found in the order
    }
}
