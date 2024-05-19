package com.example.LibrarySystem.StockBrokerageSystem.System3.Notification;

import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.NotificationStatus;
import com.example.LibrarySystem.StockBrokerageSystem.System3.Enum.NotificationType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class Notification {
    private String id;
    private NotificationType type;
    private String message;
    private Date createdAt;
    private NotificationStatus status;

    public Notification(String id, NotificationType type, String message) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.createdAt = new Date();
        this.status = NotificationStatus.UNREAD;
    }

    // Create a notification for an order execution
    public static Notification createOrderExecutedNotification(String orderId) {
        String message = "Your order with ID " + orderId + " has been executed.";
        return new Notification(generateId(), NotificationType.ORDER_EXECUTED, message);
    }

    // Create a notification for account status change
    public static Notification createAccountStatusChangedNotification(String accountId, String newStatus) {
        String message = "Your account with ID " + accountId + " status has been changed to " + newStatus + ".";
        return new Notification(generateId(), NotificationType.ACCOUNT_STATUS_CHANGED, message);
    }

    // Create a notification for funds deposited
    public static Notification createFundsDepositedNotification(String accountId, double amount) {
        String message = "An amount of " + amount + " has been deposited into your account with ID " + accountId + ".";
        return new Notification(generateId(), NotificationType.FUNDS_DEPOSITED, message);
    }

    // Create a notification for funds withdrawn
    public static Notification createFundsWithdrawnNotification(String accountId, double amount) {
        String message = "An amount of " + amount + " has been withdrawn from your account with ID " + accountId + ".";
        return new Notification(generateId(), NotificationType.FUNDS_WITHDRAWN, message);
    }

    // Generate a unique ID for notifications (simple UUID for demonstration)
    private static String generateId() {
        return java.util.UUID.randomUUID().toString();
    }

    // Mark the notification as read
    public void markAsRead() {
        this.status = NotificationStatus.READ;
    }

    // Check if the notification is unread
    public boolean isUnread() {
        return this.status == NotificationStatus.UNREAD;
    }

    // Send the notification (assuming a simple print for demonstration)
    public void sendNotification() {
        // In a real application, this method might send an email, SMS, or push notification
        System.out.println("Sending Notification: " + this.message);
    }
}
