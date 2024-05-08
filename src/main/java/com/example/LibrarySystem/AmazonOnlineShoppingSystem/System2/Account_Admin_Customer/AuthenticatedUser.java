package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Account_Admin_Customer;

public class AuthenticatedUser extends Customer {
    private Account account;
    private Order order;

    public OrderStatus placeOrder(Order order);

    public ShoppingCart getShoppingCart() {
        // functionality
    }
}
