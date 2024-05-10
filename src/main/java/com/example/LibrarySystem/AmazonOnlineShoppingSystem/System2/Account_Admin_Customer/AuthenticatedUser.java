package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Account_Admin_Customer;

import java.util.Date;

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
        if (order != null && order.getStatus() == OrderStatus.PENDING) {
            order.setOrderDate(new Date());
            this.order = order;
            return order.getStatus();
        }
        return null; // Order cannot be placed
    }

    public ShoppingCart getShoppingCart() {
        if (order != null) {
            return order.getShoppingCart();
        }
        return null;
    }

    public boolean cancelOrder() {
        if (order != null && order.getStatus() == OrderStatus.PENDING) {
            order.setStatus(OrderStatus.CANCELED);
            return true;
        }
        return false; // Order cannot be cancelled
    }

    public boolean returnOrder() {
        if (order != null && order.getStatus() == OrderStatus.SHIPPED) {
            order.setStatus(OrderStatus.REFUNDED);
            return true;
        }
        return false; // Order cannot be returned
    }
}
