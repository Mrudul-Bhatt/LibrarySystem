package com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.OrderStatus;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.TimeEnforcementType;
import com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot.StockPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@Builder
public abstract class Order {
    public boolean isBuyOrder;
    private String orderNumber;
    private OrderStatus status;
    private TimeEnforcementType timeEnforcement;
    private Date creationTime;
    private HashMap<Integer, OrderPart> parts = new HashMap<>();
    private double totalQuantity; // Total quantity for the order
    private double totalPrice; // Total price for the order
    private StockPosition stockPosition; // Reference to StockPosition

    public Order(boolean isBuyOrder, String orderNumber, TimeEnforcementType timeEnforcement,
                 StockPosition stockPosition) {
        this.isBuyOrder = isBuyOrder;
        this.orderNumber = orderNumber;
        this.timeEnforcement = timeEnforcement;
        this.creationTime = new Date();
        this.status = OrderStatus.OPEN; // Assume OrderStatus is an enum with values like NEW, FILLED, etc.
        this.stockPosition = stockPosition;
    }

    // Calculate the average price of all parts in this order
    public double getAveragePrice() {
        if (parts.isEmpty()) {
            return 0;
        }

        double totalCost = 0;
        double totalQuantity = 0;

        for (OrderPart part : parts.values()) {
            totalCost += part.getPrice() * part.getQuantity();
            totalQuantity += part.getQuantity();
        }

        return totalCost / totalQuantity;
    }

    public boolean saveInDatabase() {
        // Placeholder for actual save logic
        System.out.println("Order saved in database.");
        return true;
    }

    public void addOrderPart(OrderPart part) {
        parts.put(parts.size() + 1, part);
        updateTotalValues();
    }

    // Method to validate the order (e.g., check if quantity and price are positive)
    public boolean validateOrder() {
        return totalQuantity > 0 && totalPrice > 0;
    }

    // Method to calculate the total order value
    public double calculateTotalValue() {
        double totalValue = 0;
        for (OrderPart part : parts.values()) {
            totalValue += part.getPrice() * part.getQuantity();
        }
        return totalValue;
    }

    // Method to generate an order summary
    public String getOrderSummary() {
        return "Order Number: " + orderNumber + "\n" +
                "Order Type: " + (isBuyOrder ? "Buy" : "Sell") + "\n" +
                "Status: " + status + "\n" +
                "Total Quantity: " + totalQuantity + "\n" +
                "Total Price: " + totalPrice + "\n" +
                "Creation Time: " + creationTime + "\n" +
                "Total Value: " + calculateTotalValue();
    }

    // Method to update total quantity and price
    private void updateTotalValues() {
        totalQuantity = 0;
        totalPrice = 0;
        for (OrderPart part : parts.values()) {
            totalQuantity += part.getQuantity();
            totalPrice += part.getPrice() * part.getQuantity();
        }
    }
}
