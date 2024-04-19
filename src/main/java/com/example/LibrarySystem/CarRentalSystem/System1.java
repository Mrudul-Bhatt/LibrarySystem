package com.example.LibrarySystem.CarRentalSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

enum VehicleStatus {
    AVAILABLE,
    RESERVED,
    LOST,
    BEING_SERVICED
}

enum AccountStatus {
    ACTIVE,
    CLOSED,
    CANCELED,
    BLACKLISTED,
    BLOCKED
}

enum ReservationStatus {
    ACTIVE,
    PENDING,
    CONFIRMED,
    COMPLETED,
    CANCELED
}

enum PaymentStatus {
    UNPAID,
    PENDING,
    COMPLETED,
    CANCELED,
    REFUNDED
}

enum VanType {
    PASSENGER,
    CARGO
}

enum CarType {
    ECONOMY,
    COMPACT,
    INTERMEDIATE,
    STANDARD,
    FULL_SIZE,
    PREMIUM,
    LUXURY
}

enum MotorcycleType {
    STANDARD,
    CRUISER,
    TOURING,
    SPORTS,
    OFF_ROAD,
    DUAL_PURPOSE
}

enum TruckType {
    LIGHT_DUTY,
    MEDIUM_DUTY,
    HEAVY_DUTY
}

enum VehicleLogType {
    RESERVED,
    RETURNED,
    ACCIDENT,
    FUELING,
    CLEANING_SERVICE,
    OIL_CHANGE,
    REPAIR,
    OTHER
}

@Getter
@Setter
class Address {
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
    private String country;
}

@Getter
@Setter
class Person {
    private String name;
    private Address address;
    private String email;
    private String phoneNumber;
}

@Getter
@Setter
class Driver extends Person {
    private int driverId;
}

abstract class Account extends Person {
    private String accountId;
    private String password;
    private AccountStatus status;

    public abstract boolean resetPassword();
}

class Receptionist extends Account {
    private Date dateJoined;

    public List<Customer> searchCustomer(String name);

    public boolean addReservation();

    public boolean cancelReservation();

    public boolean resetPassword() {
    }
}

class Customer extends Account {
    private String licenseNumber;
    private Date licenseExpiry;

    public boolean addReservation();

    public boolean cancelReservation();

    public List<VehicleReservation> getReservations();

    public boolean resetPassword() {
    }
}

abstract class Vehicle {
    private String vehicleId;
    private String licenseNumber;
    private int passengerCapacity;
    private boolean hasSunroof;
    private VehicleStatus status;
    private String model;
    private int manufacturingYear;
    private int mileage;
    private List<VehicleLog> log;

    public boolean reserveVehicle() {
        if (status == VehicleStatus.AVAILABLE) {
            status = VehicleStatus.RESERVED;
            log.add(new VehicleLog(VehicleLogType.RESERVED, "Vehicle reserved", new Date()));
            return true;
        } else {
            System.out.println("Cannot reserve the vehicle. Vehicle is not available.");
            return false;
        }
    }

    public boolean returnVehicle() {
        if (status == VehicleStatus.RESERVED) {
            status = VehicleStatus.AVAILABLE;
            log.add(new VehicleLog(VehicleLogType.RETURNED, "Vehicle returned", new Date()));
            return true;
        } else {
            System.out.println("Cannot return the vehicle. Vehicle is not reserved.");
            return false;
        }
    }
}

class Car extends Vehicle {
    private CarType carType;
}

class Van extends Vehicle {
    private VanType vanType;
}

class Truck extends Vehicle {
    private TruckType truckType;
}

class Motorcycle extends Vehicle {
    private MotorcycleType motorcycleType;
}

abstract class Equipment {
    private int equipmentId;
    private int price;
}

class Navigation extends Equipment {
}

class ChildSeat extends Equipment {
}

class SkiRack extends Equipment {
}

abstract class Service {
    private int serviceId;
    private int price;
}

class DriverService extends Service {
    private int driverId;
}

class RoadsideAssistance extends Service {
}

class WiFi extends Service {
}

abstract class Payment {
    private double amount;
    private Date timestamp;
    private PaymentStatus status;

    public abstract boolean makePayment();
}

class Cash extends Payment {
    public boolean makePayment() {
    }
}

class CreditCard extends Payment {
    private String nameOnCard;
    private String cardNumber;
    private String billingAddress;
    private int code;

    public boolean makePayment() {
    }
}

@Getter
@Setter
class VehicleLog {
    private int logId;
    private VehicleLogType logType;
    private String description;
    private Date creationDate;

    public VehicleLog(VehicleLogType logType, String description, Date creationDate) {
        this.logType = logType;
        this.description = description;
        this.creationDate = creationDate;
    }
}

class VehicleReservation {
    private int reservationId;
    private String customerId;
    private String vehicleId;
    private Date creationDate;
    private ReservationStatus status;
    private Date dueDate;
    private Date returnDate;
    private String pickupLocation;
    private String returnLocation;

    private List<Equipment> equipments;
    private List<Service> services;

    public VehicleReservation(int reservationId, String customerId, String vehicleId, Date creationDate,
            ReservationStatus status, Date dueDate, String pickupLocation, String returnLocation) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.creationDate = creationDate;
        this.status = status;
        this.dueDate = dueDate;
        this.pickupLocation = pickupLocation;
        this.returnLocation = returnLocation;
        this.equipments = new ArrayList<>();
        this.services = new ArrayList<>();
    }

    public static VehicleReservation getReservationDetails();

    public boolean addEquipment(Equipment equipment) {
        return equipments.add(equipment);
    }

    public boolean addService(Service service) {
        return services.add(service);
    }
}

abstract class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public abstract void sendNotification(Account account);
}

class SmsNotification extends Notification {

    public void sendNotification(Account account) {
    }
}

class EmailNotification extends Notification {

    public void sendNotification(Account account) {
    }
}

class ParkingStall {
    private int stallId;
    private String locationIdentifier;
}

class Fine {
    private double amount;
    private String reason;

    public double calculateFine();
}

interface Search {
    public List<Vehicle> searchByType(String type);

    public List<Vehicle> searchByModel(String model);
}

class VehicleCatalog implements Search {
    private HashMap<String, List<Vehicle>> vehicleTypes;
    private HashMap<String, List<Vehicle>> vehicleModels;

    public List<Vehicle> searchByType(String type) {
    }

    public List<Vehicle> searchByModel(String model) {
    }
}

class CarRentalBranch {
    private String name;
    private Address address;
    private List<ParkingStall> stalls;

    public Address getLocation();
}

class CarRentalSystem {
    private String name;
    private List<CarRentalBranch> branches;

    public void addNewBranch(CarRentalBranch branch);

    // The CarRentalSystem is a singleton class that ensures it will have only one
    // active instance at a time
    private static CarRentalSystem system = null;

    // Created a static method to access the singleton instance of CarRentalSystem
    // class
    public static CarRentalSystem getInstance() {
        if (system == null) {
            system = new CarRentalSystem();
        }
        return system;
    }
}

public class System1 {

}
