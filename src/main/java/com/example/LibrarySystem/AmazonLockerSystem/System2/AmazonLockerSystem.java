package com.example.LibrarySystem.AmazonLockerSystem.System2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

enum LockerSize {
    EXTRA_SMALL,
    SMALL,
    MEDIUM,
    LARGE,
    EXTRA_LARGE,
    DOUBLE_EXTRA_LARGE
}

enum LockerState {
    CLOSED,
    BOOKED,
    AVAILABLE
}

@Getter
@Setter
class Item {
    private String itemId;
    private int quantity;

    public Item(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }
}

@Getter
@Setter
class Order {
    private String orderId;
    private List<Item> items;
    private String deliveryLocation;

    public Order(String orderId, List<Item> items, String deliveryLocation) {
        this.orderId = orderId;
        this.items = items;
        this.deliveryLocation = deliveryLocation;
    }
}

@Getter
@Setter
class Package {
    private String packageId;
    private double packageSize;
    private Order order;

    public Package(String packageId, double packageSize, Order order) {
        this.packageId = packageId;
        this.packageSize = packageSize;
        this.order = order;
    }

    public void pack() {
        // Method to pack the package
    }
}

@Getter
@Setter
class LockerPackage extends Package {
    private int codeValidDays;
    private String lockerId;
    private String packageId;
    private String code;
    private Date packageDeliveryTime;

    public LockerPackage(String packageId, double packageSize, Order order, int codeValidDays) {
        super(packageId, packageSize, order);
        this.codeValidDays = codeValidDays;
    }

    public boolean isValidCode() {
        // Check if the code is still valid
        return codeValidDays > 0;
    }

    public boolean verifyCode(String code) {
        // Verify the code against the stored code
        return this.code.equals(code);
    }
}

@Getter
@Setter
class Locker {
    private String lockerId;
    private LockerSize lockerSize;
    private String locationId;
    private LockerState lockerState;

    public Locker(String lockerId, LockerSize lockerSize, String locationId) {
        this.lockerId = lockerId;
        this.lockerSize = lockerSize;
        this.locationId = locationId;
        this.lockerState = LockerState.AVAILABLE;
    }

    public boolean addPackage() {
        // Method to add a package to the locker
        return true; // Placeholder implementation
    }

    public boolean removePackage() {
        // Method to remove a package from the locker
        return true; // Placeholder implementation
    }
}

@Getter
@Setter
class LockerLocation {
    private String name;
    private List<Locker> lockers;
    private double longitude;
    private double latitude;
    private Date openTime;
    private Date closeTime;

    public LockerLocation(String name, double longitude, double latitude, Date openTime, Date closeTime) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.lockers = new ArrayList<>();
    }

    public void addLocker(Locker locker) {
        lockers.add(locker);
    }

    public void removeLocker(Locker locker) {
        lockers.remove(locker);
    }
}

@Getter
@Setter
class Notification {
    private String customerId;
    private String orderId;
    private String lockerId;
    private String code;

    public Notification(String customerId, String orderId, String lockerId, String code) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.lockerId = lockerId;
        this.code = code;
    }

    public void send() {
        // Implementation to send the notification to the customer
        System.out.println("Notification sent to customer " + customerId + " for order " + orderId + " at locker "
                + lockerId + ". Code: " + code);
    }
}

@Getter
@Setter
class LockerService {
    private List<LockerLocation> locations;

    // Singleton instance
    private static LockerService lockerService = null;

    // Private constructor to prevent instantiation
    private LockerService() {
        this.locations = new ArrayList<>();
    }

    // Static method to access the Singleton instance of LockerService class
    public static LockerService getInstance() {
        if (lockerService == null) {
            lockerService = new LockerService();
        }
        return lockerService;
    }

    // Add a LockerLocation to the list of locations
    public void addLocation(LockerLocation location) {
        locations.add(location);
    }

    // Remove a LockerLocation from the list of locations
    public void removeLocation(LockerLocation location) {
        locations.remove(location);
    }

    // Get a specific LockerLocation by its name
    public LockerLocation getLocationByName(String name) {
        for (LockerLocation location : locations) {
            if (location.getName().equals(name)) {
                return location;
            }
        }
        return null;
    }
}

public class AmazonLockerSystem {

}
