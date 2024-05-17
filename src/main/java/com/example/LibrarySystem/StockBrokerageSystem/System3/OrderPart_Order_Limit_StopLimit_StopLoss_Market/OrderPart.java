package com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class OrderPart {
    private double price;
    private double quantity;
    private Date executedAt;
}
