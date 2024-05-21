package com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.OrderStatus;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.TimeEnforcementType;
import com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot.StockPosition;

public class StopLossOrder extends Order {
    private double stopPrice;

    public StopLossOrder(boolean isBuyOrder, String orderNumber, TimeEnforcementType timeEnforcement, double stopPrice,
                         StockPosition stockPosition) {
        super(isBuyOrder, orderNumber, timeEnforcement, stockPosition);
        this.stopPrice = stopPrice;
    }

    // Method to check if the stop price condition is met
    public boolean checkStopPrice(double currentPrice) {
        return isBuyOrder ? currentPrice >= stopPrice : currentPrice <= stopPrice;
    }

    // Method to execute the stop loss order if the stop price condition is met
    public boolean executeOrder(double currentPrice) {
        if (!validateOrder() || !checkStopPrice(currentPrice)) {
            return false; // Order validation failed or stop price condition not met
        }
        // Placeholder for actual execution logic
        // For example, match with available orders, update status, etc.
        setStatus(OrderStatus.FILLED);
        System.out.println("Stop loss order executed.");
        return true;
    }
}
