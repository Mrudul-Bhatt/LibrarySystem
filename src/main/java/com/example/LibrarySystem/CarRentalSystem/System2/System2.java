package com.example.LibrarySystem.CarRentalSystem.System2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum VehicleStatus {
    RESERVED,
    AVAILABLE,
    LOST,
    BEING_SERVICED
}

@Data
@AllArgsConstructor
abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private VehicleStatus vehicleStatus;

    public void rentVehicle() {
        if (this.vehicleStatus == VehicleStatus.AVAILABLE) {
            this.vehicleStatus = VehicleStatus.RESERVED;
            System.out.println("Vehicle rented successfully.");
        } else {
            System.out.println("Sorry, the vehicle is not available for rental.");
        }
    }

    public void returnVehicle() {
        if (this.vehicleStatus == VehicleStatus.RESERVED) {
            this.vehicleStatus = VehicleStatus.AVAILABLE;
            System.out.println("Vehicle returned successfully.");
        } else {
            System.out.println("Vehicle cannot be returned as it was not rented.");
        }
    }
}

class Car extends Vehicle {
    public Car(String make, String model, int year, String licensePlate, VehicleStatus vehicleStatus) {
        super(make, model, year, licensePlate, vehicleStatus);
    }
}

class Van extends Vehicle {
    public Van(String make, String model, int year, String licensePlate, VehicleStatus vehicleStatus) {
        super(make, model, year, licensePlate, vehicleStatus);
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year, String licensePlate, VehicleStatus vehicleStatus) {
        super(make, model, year, licensePlate, vehicleStatus);
    }
}

class Truck extends Vehicle {
    public Truck(String make, String model, int year, String licensePlate, VehicleStatus vehicleStatus) {
        super(make, model, year, licensePlate, vehicleStatus);
    }
}

@Data
@AllArgsConstructor
@Builder
class Customer {
    private String name;
    private String contactInfo;
    private List<RentalRecord> rentalHistory;

    public void addRentalRecord(RentalRecord rentalRecord) {
        rentalHistory.add(rentalRecord);
        System.out.println("Rental record added for " + name);
    }
}

@Data
@AllArgsConstructor
@Builder
class RentalRecord {
    private Vehicle vehicle;
    private Customer customer;
    private Date rentalDate;
    private Date returnDate;
    private double rentalFee;
    private List<Equipment> equipments;
    private List<Service> services;

    public void calculateRentalFee() {
        long rentalDurationMillis = returnDate.getTime() - rentalDate.getTime();
        int rentalDurationDays = (int) (rentalDurationMillis / (1000 * 60 * 60 * 24));
        this.setRentalFee(rentalDurationDays * 50); // Assuming $50 per day rental fee
    }

    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
        System.out.println("Equipment added: " + equipment.getName());
    }

    public void addService(Service service) {
        services.add(service);
        System.out.println("Service added: " + service.getName());
    }
}

@Data
abstract class Equipment {
    private String name;
    private double price;
}

class Navigation extends Equipment {
}

class ChildSeat extends Equipment {
}

class SkiRack extends Equipment {
}

@Data
abstract class Service {
    private String name;
    private double price;
}

class DriverService extends Service {
}

class RoadsideAssistance extends Service {
}

class Wifi extends Service {
}

@Data
@AllArgsConstructor
@Builder
class VehicleInventory {
    private List<Vehicle> vehicles;

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeCar(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public Vehicle findAvailableVehicles() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleStatus() == VehicleStatus.AVAILABLE) {
                return vehicle;
            }
        }
        System.out.println("No available vehicles in inventory.");
        return null;
    }

    public List<Vehicle> getVehicleByMakeAndModel(String make, String model) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                result.add(vehicle);
            }
        }
        return result;
    }
}

@Data
class RentalSystem {
    private static RentalSystem instance;
    private VehicleInventory inventory;
    private List<RentalRecord> rentalRecords;

    private RentalSystem(VehicleInventory inventory) {
        this.inventory = inventory;
        this.rentalRecords = new ArrayList<>();
    }

    public static RentalSystem getInstance(VehicleInventory inventory) {
        if (instance == null) {
            instance = new RentalSystem(inventory);
        }
        return instance;
    }

    public void rentCar(Customer customer, Vehicle vehicle, Date rentalDate) {
        if (vehicle.getVehicleStatus() == VehicleStatus.AVAILABLE) {
            vehicle.rentVehicle();
            RentalRecord record = RentalRecord.builder().vehicle(vehicle).customer(customer).rentalDate(rentalDate)
                    .build();
            customer.addRentalRecord(record);
            rentalRecords.add(record);
            System.out.println("Car rented successfully.");
        } else {
            System.out.println("Sorry, the car is not available for rental.");
        }
    }

    public void returnCar(Customer customer, Car car) {
        for (RentalRecord record : rentalRecords) {
            if (record.getVehicle().equals(car) && record.getCustomer().equals(customer)) {
                car.returnVehicle();
                record.setReturnDate(new Date());
                record.calculateRentalFee();
                // Calculate rental fee and update rental record
                System.out.println("Car returned successfully.");
                return;
            }
        }
        System.out.println("Car rental record not found for this customer.");
    }

    // public void generateRentalReport() {
    // // Generate rental report based on rental records
    // for (RentalRecord record : rentalRecords) {
    // System.out.println("Rental Record:");
    // System.out.println("Car: " + record.getCar().getMake() + " " +
    // record.getCar().getModel());
    // System.out.println("Customer: " + record.getCustomer().getName());
    // System.out.println("Rental Date: " + record.getRentalDate());
    // System.out.println("Return Date: " + record.getReturnDate());
    // System.out.println("Rental Fee: " + record.getRentalFee());
    // System.out.println("--------------------------------------");
    // }
    // }
}

public class System2 {

}
