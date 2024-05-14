package com.example.LibrarySystem.RestaurantManagementSystem.Meal_MealItem;

import com.example.LibrarySystem.RestaurantManagementSystem.Table_TableSeat.TableSeat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Meal {
    private int mealID;
    private TableSeat seat;
    private List<MealItem> menuItems;

    public boolean addMealItem(MealItem mealItem) {
        if (menuItems == null) {
            menuItems = new ArrayList<>();
        }
        return menuItems.add(mealItem);
    }

    public boolean removeMealItem(MealItem mealItem) {
        return menuItems != null && menuItems.remove(mealItem);
    }
}
