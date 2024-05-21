package com.example.LibrarySystem.StockBrokerageSystem.System3.Enum;

public enum ErrorCode {
    SUCCESS,                  // Operation completed successfully
    INSUFFICIENT_FUNDS,       // Not enough funds for the operation
    INSUFFICIENT_STOCK,       // Not enough stock for the operation
    ORDER_CREATION_FAILED,    // Order creation failed for some reason
    MEMBER_BLOCKED,           // Member is blocked
    ACCOUNT_INACTIVE,         // Account is inactive
    INVALID_ORDER,            // Order is invalid
    UNKNOWN_ERROR;
}
