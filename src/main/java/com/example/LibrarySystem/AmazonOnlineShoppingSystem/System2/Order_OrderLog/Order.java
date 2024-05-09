package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Order_OrderLog;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Cart_CartItems.ShoppingCart;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Enums.OrderStatus;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Payment.Payment;
import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Shipment_ShipmentLog.Shipment;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Order {
    private String orderNumber;
    private OrderStatus status;
    private Date orderDate;
    private List<OrderLog> orderLog;
    private ShoppingCart shoppingCart;

    public boolean sendForShipment(Shipment shipment) {
        if (status != OrderStatus.CONFIRMED) {
            System.out.println("Order cannot be shipped as it is not yet completed.");
            return false;
        }
        if (shipment.sendForShipment()) {
            this.status = OrderStatus.SHIPPED;
            addOrderLog(new OrderLog(orderNumber, new Date(), OrderStatus.SHIPPED));
            return true;
        } else {
            System.out.println("Failed to initiate shipment for the order.");
            return false;
        }
    }

    public boolean cancelOrder() {
        if (status == OrderStatus.CANCELED || status == OrderStatus.REFUNDED) {
            System.out.println("Order has already been cancelled or returned.");
            return false;
        }
        if (status == OrderStatus.CONFIRMED || status == OrderStatus.SHIPPED) {
            System.out.println("Cannot cancel order, it has already been shipped or completed.");
            return false;
        }
        if (status == OrderStatus.PENDING || status == OrderStatus.UNSHIPPED) {
            this.status = OrderStatus.CANCELED;
            addOrderLog(new OrderLog(orderNumber, new Date(), OrderStatus.CANCELED));
            return true;
        }
        return false;
    }

    public boolean addOrderLog(OrderLog orderLog) {
        return this.orderLog.add(orderLog);
    }

    public boolean makePayment(Payment payment) {
        // Implement logic to process payment
        return true; // Placeholder
    }

    public void generateOrderInvoice() {
        // Implement logic to generate an invoice for the order
    }

    public void trackOrder() {
        // Implement logic to track the status of the order
    }

    public void notifyCustomer(String message) {
        // Implement logic to notify the customer about the order status
    }

    public void reorder() {
        // Implement logic to reorder the same items from the order
    }

}
