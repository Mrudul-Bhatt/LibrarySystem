package com.example.LibrarySystem.RestaurantManagementSystem.Menu_MenuSection_MenuItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MenuSection {
    private int menuSectionID;
    private String title;
    private String description;
    private List<MenuItem> menuItems;

    public boolean addMenuItem(MenuItem menuItem) {
        return menuItems.add(menuItem);
    }
}
