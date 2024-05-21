package com.example.LibrarySystem.StockBrokerageSystem.System3.Account_Member_Admin;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.ErrorCode;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.OrderStatus;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.TimeEnforcementType;
import com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market.LimitOrder;
import com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market.Order;
import com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market.OrderPart;
import com.example.LibrarySystem.StockBrokerageSystem.System3.StockExchange.StockExchange;
import com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot.StockPosition;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Member extends Account {
    private double availableFundsForTrading;
    private Date dateOfMembership;
    private HashMap<String, StockPosition> stockPositions;
    private HashMap<Integer, Order> activeOrders;

    // Place a sell limit order
    public ErrorCode placeSellLimitOrder(String stockId, float quantity, int limitPrice,
                                         TimeEnforcementType enforcementType) {
        // Check if the member has enough stock
        if (stockPositions.containsKey(stockId) && stockPositions.get(stockId).getTotalQuantity() >= quantity) {
            LimitOrder order = new LimitOrder(false, generateOrderNumber(), enforcementType, quantity,
                    stockPositions.getOrDefault(stockId, null));
            order.addOrderPart(new OrderPart(limitPrice, quantity, new Date()));
            if (StockExchange.getInstance().createOrder(order)) {
                activeOrders.put(order.getOrderNumber().hashCode(), order);
                return ErrorCode.SUCCESS;
            }
        }
        return ErrorCode.INSUFFICIENT_STOCK;
    }

    // Place a buy limit order
    public ErrorCode placeBuyLimitOrder(String stockId, float quantity, int limitPrice,
                                        TimeEnforcementType enforcementType) {
        // Check if the member has enough funds
        double requiredFunds = limitPrice * quantity;
        if (availableFundsForTrading >= requiredFunds) {
            LimitOrder order = new LimitOrder(true, generateOrderNumber(), enforcementType, quantity,
                    stockPositions.getOrDefault(stockId, null));
            order.addOrderPart(new OrderPart(limitPrice, quantity, new Date()));
            if (StockExchange.getInstance().createOrder(order)) {
                activeOrders.put(order.getOrderNumber().hashCode(), order);
                availableFundsForTrading -= requiredFunds;
                return ErrorCode.SUCCESS;
            }
        }
        return ErrorCode.INSUFFICIENT_FUNDS;
    }

    // Callback from stock exchange
    public void callbackStockExchange(int orderId, List<OrderPart> orderParts, OrderStatus status) {
        Order order = activeOrders.get(orderId);
        if (order != null) {
            for (OrderPart part : orderParts) {
                order.addOrderPart(part);
            }
            order.setStatus(status);
            if (status == OrderStatus.FILLED || status == OrderStatus.CANCELED) {
                activeOrders.remove(orderId);
            }
        }
    }

    // Generate order number
    private String generateOrderNumber() {
        return UUID.randomUUID().toString();
    }

    // Deposit funds
    public void depositFunds(double amount) {
        availableFundsForTrading += amount;
        System.out.println("Funds deposited: " + amount);
    }

    // Withdraw funds
    public boolean withdrawFunds(double amount) {
        if (availableFundsForTrading >= amount) {
            availableFundsForTrading -= amount;
            System.out.println("Funds withdrawn: " + amount);
            return true;
        }
        System.out.println("Insufficient funds for withdrawal: " + amount);
        return false;
    }

    // View stock positions
    public void viewStockPositions() {
        System.out.println("Stock Positions for member: " + getName());
        for (StockPosition position : stockPositions.values()) {
            System.out.println("Stock: " + position.getSymbol() + ", Quantity: " + position.getTotalQuantity());
        }
    }

}
