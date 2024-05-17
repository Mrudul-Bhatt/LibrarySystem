package com.example.LibrarySystem.StockBrokerageSystem.System3.OrderPart_Order_Limit_StopLimit_StopLoss_Market;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.OrderStatus;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.TimeEnforcementType;
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
    private HashMap<Integer, OrderPart> parts;

    public void setStatus(OrderStatus status);

    public boolean saveInDatabase();

    public void addOrderParts(OrderPart parts);
}
