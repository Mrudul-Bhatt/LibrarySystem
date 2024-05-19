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

    // Calculate the total cost of this order part
    public double calculateTotalCost() {
        return this.price * this.quantity;
    }

    // Check if the order part was executed within a given time range
    public boolean isExecutedWithin(Date startTime, Date endTime) {
        return this.executedAt.after(startTime) && this.executedAt.before(endTime);
    }
}
