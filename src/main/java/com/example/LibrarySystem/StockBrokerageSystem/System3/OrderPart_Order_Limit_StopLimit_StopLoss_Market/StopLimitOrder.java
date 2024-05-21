package com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.OrderStatus;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.TimeEnforcementType;
import com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot.StockPosition;

public class StopLimitOrder extends Order {
    private double stopPrice;
    private double limitPrice;

    public StopLimitOrder(boolean isBuyOrder, String orderNumber, TimeEnforcementType timeEnforcement, double stopPrice,
                          double limitPrice, StockPosition stockPosition) {
        super(isBuyOrder, orderNumber, timeEnforcement, stockPosition);
        this.stopPrice = stopPrice;
        this.limitPrice = limitPrice;
    }

    // Method to check if the stop price condition is met
    public boolean checkStopPrice(double currentPrice) {
        return isBuyOrder ? currentPrice >= stopPrice : currentPrice <= stopPrice;
    }

    // Method to check if the limit price condition is met
    public boolean checkLimitPrice(double currentPrice) {
        return isBuyOrder ? currentPrice <= limitPrice : currentPrice >= limitPrice;
    }

    // Method to execute the stop limit order if the stop and limit price conditions are met
    public boolean executeOrder(double currentPrice) {
        if (!validateOrder() || !checkStopPrice(currentPrice) || !checkLimitPrice(currentPrice)) {
            return false; // Order validation failed or stop/limit price conditions not met
        }
        // Placeholder for actual execution logic
        // For example, match with available orders, update status, etc.
        setStatus(OrderStatus.FILLED);
        System.out.println("Stop limit order executed.");
        return true;
    }
}
