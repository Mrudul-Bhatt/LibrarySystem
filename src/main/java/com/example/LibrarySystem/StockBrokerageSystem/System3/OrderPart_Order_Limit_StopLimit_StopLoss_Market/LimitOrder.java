package com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.OrderStatus;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.TimeEnforcementType;
import com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot.StockPosition;

public class LimitOrder extends Order {
    private double limitPrice;

    public LimitOrder(boolean isBuyOrder, String orderNumber, TimeEnforcementType timeEnforcement, double limitPrice,
                      StockPosition stockPosition) {
        super(isBuyOrder, orderNumber, timeEnforcement, stockPosition);
        this.limitPrice = limitPrice;
    }

    // Method to check if the limit price condition is met
    public boolean checkLimitPrice(double currentPrice) {
        return isBuyOrder ? currentPrice <= limitPrice : currentPrice >= limitPrice;
    }

    // Method to execute the limit order if the limit price condition is met
    public boolean executeOrder(double currentPrice) {
        if (!validateOrder() || !checkLimitPrice(currentPrice)) {
            return false; // Order validation failed or limit price condition not met
        }
        // Placeholder for actual execution logic
        // For example, match with available orders, update status, etc.
        setStatus(OrderStatus.FILLED);
        System.out.println("Limit order executed at limit price.");
        return true;
    }
}
