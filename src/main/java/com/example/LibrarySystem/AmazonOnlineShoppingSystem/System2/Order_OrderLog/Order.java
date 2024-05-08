package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Order_OrderLog;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Cart_CartItems.ShoppingCart;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Enums.OrderStatus;

import java.util.Date;

public class Order {
    private String orderNumber;
    private OrderStatus status;
    private Date orderDate;
    private List<OrderLog> orderLog;
    private ShoppingCart shoppingCart;

    public boolean sendForShipment();

    public boolean makePayment(Payment payment);

    public boolean addOrderLog(OrderLog orderLog);
}
