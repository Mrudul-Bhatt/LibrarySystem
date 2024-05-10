package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Account_Admin_Customer;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Cart_CartItems.ShoppingCart;

public class Guest extends Customer {
    public boolean registerAccount(String userName, String password, String name, String email, String phone) {
        // Simulate account registration logic
        if (userName != null && password != null && name != null && email != null && phone != null) {
            // Create a new account with the provided information
            Account newAccount = new Account(userName, password, name, null, null, email, phone, null, null);
            // Optionally, you can add the new account to a list of registered accounts
            // For simulation purposes, we assume the account is successfully registered
            return true;
        }
        return true;
    }

    public ShoppingCart getShoppingCart() {

    }
}
