package com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.OrderStatus;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.TimeEnforcementType;
import com.example.LibrarySystem.StockBrokerageSystem.System3.StockExchange.StockExchange;
import com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot.StockPosition;

import java.util.Date;

public class MarketOrder extends Order {
    public MarketOrder(boolean isBuyOrder, String orderNumber, TimeEnforcementType timeEnforcement,
                       StockPosition stockPosition) {
        super(isBuyOrder, orderNumber, timeEnforcement, stockPosition);
    }
    
    // Method to execute the market order immediately
    public boolean executeOrder() {
//        if (!validateOrder()) {
//            return false; // Order validation failed
//        }
//        // Placeholder for actual execution logic
//        // For example, match with available market orders, update status, etc.
//        setStatus(OrderStatus.FILLED);
//        System.out.println("Market order executed immediately.");
//        return true;

        double marketPrice = StockExchange.getInstance().getStockPrice(getStockPosition().getSymbol());
        OrderPart part = new OrderPart(marketPrice, getTotalQuantity(), new Date());
        addOrderPart(part);
        setStatus(OrderStatus.FILLED);
        saveInDatabase();
        return true;
    }
}
