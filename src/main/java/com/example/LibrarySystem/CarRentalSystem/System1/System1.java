package com.example.LibrarySystem.CarRentalSystem.System1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
class Car {
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private boolean available;

    public void rentOut() {
        if (this.available) {
            this.available = false;
            System.out.println("Car rented out successfully.");
        } else {
            System.out.println("Car is already rented out.");
        }
    }

    public void returnCar() {
        if (!this.available) {
            this.available = true;
            System.out.println("Car returned successfully.");
        } else {
            System.out.println("Car is already available.");
        }
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
    private Car car;
    private Customer customer;
    private Date rentalDate;
    private Date returnDate;
    private double rentalFee;

    public double calculateRentalFee() {
        long rentalDurationMillis = returnDate.getTime() - rentalDate.getTime();
        int rentalDurationDays = (int) (rentalDurationMillis / (1000 * 60 * 60 * 24));
        return rentalDurationDays * 50; // Assuming $50 per day rental fee
    }
}

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
class CarInventory {
    private List<Car> cars;

    public void addCar(Car car) {
        cars.add(car);
        System.out.println("Car added to inventory: " + car.getMake() + " " + car.getModel());
    }

    public void removeCar(Car car) {
        cars.remove(car);
        System.out.println("Car removed from inventory: " + car.getMake() + " " + car.getModel());
    }

    public Car findAvailableCar() {
        for (Car car : cars) {
            if (car.isAvailable()) {
                return car;
            }
        }
        System.out.println("No available cars in inventory.");
        return null;
    }

    public List<Car> getCarsByMakeAndModel(String make, String model) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model)) {
                result.add(car);
            }
        }
        return result;
    }
}

@Data
class RentalSystem {
    private CarInventory inventory;
    private List<RentalRecord> rentalRecords;
    private static RentalSystem instance;

    private RentalSystem(CarInventory inventory) {
        this.inventory = inventory;
        this.rentalRecords = new ArrayList<>();
    }

    public static RentalSystem getInstance(CarInventory inventory) {
        if (instance == null) {
            instance = new RentalSystem(inventory);
        }
        return instance;
    }

    public void rentCar(Customer customer, Car car, Date rentalDate) {
        if (car.isAvailable()) {
            car.rentOut();
            RentalRecord record = RentalRecord.builder().car(car).customer(customer).rentalDate(rentalDate).build();
            customer.addRentalRecord(record);
            rentalRecords.add(record);
            System.out.println("Car rented successfully.");
        } else {
            System.out.println("Sorry, the car is not available for rental.");
        }
    }

    public void returnCar(Customer customer, Car car) {
        for (RentalRecord record : rentalRecords) {
            if (record.getCar().equals(car) && record.getCustomer().equals(customer)) {
                car.returnCar();
                record.setReturnDate(new Date());
                record.calculateRentalFee();
                // Calculate rental fee and update rental record
                System.out.println("Car returned successfully.");
                return;
            }
        }
        System.out.println("Car rental record not found for this customer.");
    }

    public void generateRentalReport() {
        // Generate rental report based on rental records
        for (RentalRecord record : rentalRecords) {
            System.out.println("Rental Record:");
            System.out.println("Car: " + record.getCar().getMake() + " " + record.getCar().getModel());
            System.out.println("Customer: " + record.getCustomer().getName());
            System.out.println("Rental Date: " + record.getRentalDate());
            System.out.println("Return Date: " + record.getReturnDate());
            System.out.println("Rental Fee: " + record.getRentalFee());
            System.out.println("--------------------------------------");
        }
    }
}

public class System1 {

    public static void main() {

        // Create some cars
        Car car1 = new Car("Toyota", "Corolla", 2020, "ABC123", true);
        Car car2 = new Car("Honda", "Civic", 2019, "XYZ456", true);

        // Create some customers
        Customer customer1 = Customer.builder().name("John Doe").contactInfo("john@example.com")
                .build();
        Customer customer2 = Customer.builder().name("Jane Smith").contactInfo("jane@example.com").build();

        // Create a car inventory and add cars
        CarInventory inventory = new CarInventory();
        inventory.addCar(car1);
        inventory.addCar(car2);

        // Rent a car
        RentalSystem rentalSystem = RentalSystem.getInstance(inventory);
        rentalSystem.rentCar(customer1, car1, new Date());

        // Simulate rental duration
        try {
            Thread.sleep(2000); // Simulate rental duration of 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return the car
        rentalSystem.returnCar(customer1, car1);

        // Generate rental report
        rentalSystem.generateRentalReport();

        // Find and rent another car
        Car availableCar = inventory.findAvailableCar();
        if (availableCar != null) {
            rentalSystem.rentCar(customer2, availableCar, new Date());
        }
    }
}
