package com.example.LibrarySystem.AirlineManagementSystem.System2.Notification;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Address_Acc_Passenger.Account;
import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.NotificationStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;
    private NotificationStatus status;

    public Notification(int notificationId, String content) {
        this.notificationId = notificationId;
        this.createdOn = new Date();
        this.content = content;
        this.status = NotificationStatus.PENDING;
    }

    // Method to send notification to an account
    public void sendNotification(Account account) {
        // Simulate sending notification (e.g., email, SMS)
        System.out.println("Sending notification to account: " + account.getUsername());
        System.out.println("Notification Content: " + content);

        // After sending, update status
        status = NotificationStatus.SENT;
    }

    // Method to schedule a notification for future delivery
    public void scheduleNotification(Account account, Date scheduleDate) {
        // Simulate scheduling logic
        System.out.println(
                "Notification scheduled to be sent to account: " + account.getUsername() + " on " + scheduleDate);

        // Update status to scheduled
        status = NotificationStatus.SCHEDULED;
    }

    // Method to cancel a scheduled notification
    public void cancelScheduledNotification() {
        if (status == NotificationStatus.SCHEDULED) {
            System.out.println("Scheduled notification cancelled.");
            status = NotificationStatus.CANCELLED;
        } else {
            System.out.println("No scheduled notification to cancel.");
        }
    }

    // Method to check notification status
    public NotificationStatus getNotificationStatus() {
        return status;
    }

}
