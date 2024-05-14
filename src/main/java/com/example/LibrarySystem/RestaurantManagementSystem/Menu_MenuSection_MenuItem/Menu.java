package com.example.LibrarySystem.RestaurantManagementSystem.Menu_MenuSection_MenuItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Menu {
    private int menuID;
    private String title;
    private String description;
    private double price;
    private List<MenuSection> menuSections;

    public boolean addMenuSection(MenuSection menuSection) {
        if (menuSections == null) {
            menuSections = new ArrayList<>();
        }
        return menuSections.add(menuSection);
    }

    public boolean print() {
        // Implementation for printing the menu
        return true; // Placeholder return
    }
}
