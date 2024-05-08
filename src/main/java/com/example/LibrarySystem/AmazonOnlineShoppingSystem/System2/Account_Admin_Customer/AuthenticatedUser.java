package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Account_Admin_Customer;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Cart_CartItems.ShoppingCart;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Enums.OrderStatus;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Order_OrderLog.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticatedUser extends Customer {
    private Account account;
    private Order order;

    public OrderStatus placeOrder(Order order) {
        this.order = order;
        return order.getStatus();
    }

    public ShoppingCart getShoppingCart() {
        return order.getShoppingCart();
    }
}
