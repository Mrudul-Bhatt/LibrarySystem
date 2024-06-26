package com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Order_OrderLog;

import com.example.LibrarySystem.AmazonOnlineShoppingSystem.System2.Enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class OrderLog {
    private String orderNumber;
    private Date creationDate;
    private OrderStatus status;
}
