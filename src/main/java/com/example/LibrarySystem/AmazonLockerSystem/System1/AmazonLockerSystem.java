package com.example.LibrarySystem.AmazonLockerSystem.System1;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

enum ProductSize {
    SMALL, MEDIUM, LARGE
}

@Getter
@Setter
class Product {
    private String id;
    private String name;
    private ProductSize size;

    public Product(String id, String name, ProductSize size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }
}

// Interface for actors Customer and DeliveryGuy
interface Actor {
    void enterCode(String code);

    void addProduct(Product product);

    void removeProduct(String productId);

    void returnNotification(String productId);
}

@Getter
@Setter
class Customer implements Actor {
    private String customerId;

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public void enterCode(String code) {
        // Implement code entering functionality for customer
    }

    @Override
    public void addProduct(Product product) {
        // Implement product adding functionality for customer
    }

    @Override
    public void removeProduct(String productId) {
        // Implement product removing functionality for customer
    }

    @Override
    public void returnNotification(String productId) {
        // Implement return notification functionality for customer
    }

    public void submitReturnRequest(Product product) {
        // Implement return request submission functionality for customer
    }

    public void overdueNotification() {
        // Implement overdue notification functionality for customer
    }
}

@Getter
@Setter
class DeliveryGuy implements Actor {
    private String deliveryGuyId;

    public DeliveryGuy(String deliveryGuyId) {
        this.deliveryGuyId = deliveryGuyId;
    }

    @Override
    public void enterCode(String code) {
        // Implement code entering functionality for delivery guy
    }

    @Override
    public void addProduct(Product product) {
        // Implement product adding functionality for delivery guy
    }

    @Override
    public void removeProduct(String productId) {
        // Implement product removing functionality for delivery guy
    }

    @Override
    public void returnNotification(String productId) {
        // Implement return notification functionality for delivery guy
    }
}

@Getter
@Setter
class System {
    private List<Locker> lockers;

    public System(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public boolean validateCode(String code) {
        // Implement code validation functionality
        return false;
    }

    public Locker findLocker(String code) {
        // Implement locker finding functionality
        return null;
    }

    public void lockDoor(Locker locker) {
        // Implement door locking functionality
    }

    public void unlockDoor(Locker locker) {
        // Implement door unlocking functionality
    }

    public void returnNotification(String productId) {
        // Implement return notification functionality for the system
    }

    public String generateCode() {
        // Implement code generation functionality
        return null;
    }

    public Locker issueLocker(ProductSize size) {
        // Implement locker issuing functionality based on product size
        return null;
    }

    public void overdueNotification() {
        // Implement overdue notification functionality for the system
    }

    public void deliveryNotification(String productId) {
        // Implement delivery notification functionality for the system
    }
}

@Getter
@Setter
class Locker {
    private String lockerId;
    private boolean isLocked;
    private Product product;

    public Locker(String lockerId) {
        this.lockerId = lockerId;
        this.isLocked = true;
        this.product = null;
    }

    public String getLockerId() {
        return lockerId;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void lock() {
        this.isLocked = true;
    }

    public void unlock() {
        this.isLocked = false;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void removeProduct() {
        this.product = null;
    }
}

public class AmazonLockerSystem {

}
