package com.example.LibrarySystem.StockBrokerageSystem.System3.Account_Member_Admin;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.OrderStatus;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.TimeEnforcementType;
import com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market.Order;
import com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market.OrderPart;
import com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot.StockPosition;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Builder
public class Member extends Account {
    private double availableFundsForTrading;
    private Date dateOfMembership;
    private HashMap<String, StockPosition> stockPositions;
    private HashMap<Integer, Order> activeOrders;

    public ErrorCode placeSellLimitOrder(String stockId, float quantity, int limitPrice, TimeEnforcementType enforcementType);

    public ErrorCode placeBuyLimitOrder(String stockId, float quantity, int limitPrice, TimeEnforcementType enforcementType);

    public void callbackStockExchange(int orderId, List<OrderPart> orderParts, OrderStatus status);

}
