package com.example.LibrarySystem.StockBrokerageSystem.System3.StockPosition_StockLot;

import com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class StockLot {
    private String iotNumber;
    private Order buyingOrder;

    public double getBuyingPrice();
}
