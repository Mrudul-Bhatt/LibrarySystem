package com.example.LibrarySystem.VendingMachine.VendingSystem2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

enum ProductType {
    CHOCOLATE,
    SNACK,
    BEVERAGE,
    OTHER
}

interface State {
    public void insertMoney(VendingMachine machine, double amount);

    public void pressButton(VendingMachine machine, int rackNumber);

    public void returnChange(double amount);

    public void updateInventory(VendingMachine machine, int rackNumber);

    public void dispenseProduct(VendingMachine machine, int rackNumber);
}

class NoMoneyInsertedState implements State {
    public void insertMoney(VendingMachine machine, double amount) {
        // changes state to MonenInsertedState
        machine.setAmount(amount);
        machine.setCurrentState(machine.getMoneyInsertedState());
    }

    public void pressButton(VendingMachine machine, int rackNumber) {
        // Display message indicating that money needs to be inserted first
        System.out.println("Please insert money first.");
    }

    public void returnChange(double amount) {
        // Display message indicating that no money was inserted
        System.out.println("No money to return.");
    }

    public void updateInventory(VendingMachine machine, int rackNumber) {
        // Display message indicating that no action can be taken without money inserted
        System.out.println("Cannot update inventory. Please insert money first.");
    }

    public void dispenseProduct(VendingMachine machine, int rackNumber) {
        // Display message indicating that no action can be taken without money inserted
        System.out.println("Cannot dispense product. Please insert money first.");
    }
}

class MoneyInsertedState implements State {

    public void insertMoney(VendingMachine machine, double amount) {
        // Allow additional money to be inserted even if money is already inserted
        machine.setAmount(machine.getAmount() + amount);
        // Display message indicating that money has been added
        System.out.println("Money added. Total amount: " + machine.getAmount());
    }

    public void pressButton(VendingMachine machine, int rackNumber) {
        // Check if product is available
        if (rackNumber < machine.getNoOfRacks() && !machine.getInventory().isProductAvailable(rackNumber)) {
            // Display message indicating that the selected product is unavailable
            System.out.println("Selected product is unavailable.");
            return;
        }

        // Check if the inserted amount is sufficient
        double price = machine.getInventory().getProductPrice(rackNumber);
        if (machine.getAmount() >= price) {
            // Update remaining amount
            machine.setAmount(machine.getAmount() - price);
            // Change state to DispenseState
            machine.setCurrentState(machine.getDispenseState());
            // Dispense the product
            machine.dispenseProduct(rackNumber);
        } else {
            // Display message indicating that the inserted amount is insufficient
            System.out.println("Insufficient amount. Please insert more money.");
        }
    }

    public void returnChange(double amount) {
        // Return the amount as change
        System.out.println("Refund not allowed please select a product for purchase");
    }

    public void updateInventory(VendingMachine machine, int rackNumber) {
        // Display message indicating that updating inventory is not allowed in this
        // state
        System.out.println("Cannot update inventory while money is inserted and no product selected.");
    }

    public void dispenseProduct(VendingMachine machine, int rackNumber) {
        // Display message indicating that dispensing product is not allowed in this
        // state
        System.out.println("Cannot dispense product while money is inserted and no product selected.");
    }
}

class DispenseState implements State {

    public void insertMoney(VendingMachine machine, double amount) {
        // Display message indicating that money has already been inserted
        System.out.println("Money already inserted.");
    }

    public void pressButton(VendingMachine machine, int rackNumber) {
        // Display message indicating that a product is being dispensed
        System.out.println("Product is being dispensed. Please wait.");
    }

    public void returnChange(double amount) {
        // Return the remaining amount as change
        System.out.println("Returning change: " + amount);
    }

    // Admin level operation (add/delete/update)
    public void updateInventory(VendingMachine machine, int rackNumber) {
        // Display message indicating that updating inventory is not allowed in this
        // state
        System.out.println("Cannot update inventory while dispensing product.");
    }

    public void dispenseProduct(VendingMachine machine, int rackNumber) {
        // Dispense the product
        Product product = machine.getInventory().getProduct(rackNumber);
        if (product != null) {
            // Display message indicating the dispensed product
            System.out.println("Dispensing " + product.getName() + ". Enjoy your purchase!");
            // Remove the product from inventory
            machine.getInventory().removeProduct(product.getId(), rackNumber);
            // Return remaining money
            double remainingAmount = machine.getAmount();
            machine.returnChange(remainingAmount);
            // Reset the amount to 0
            machine.setAmount(0);
        }
        // Change state to NoMoneyInsertedState
        machine.setCurrentState(machine.getNoMoneyInsertedState());
    }
}

@Getter
@Setter
class Product {
    private String name;
    private int id;
    private double price;
    private ProductType type;
}

class Rack {
    private int productId;
    private int rackNumber;

    public boolean isEmpty();
}

class Inventory {
    // private List<Product> products;

    private Map<Integer, Product> products;
    private Map<Integer, Integer> rackToProductIdMap;

    public Inventory() {
        products = new HashMap<>();
        rackToProductIdMap = new HashMap<>();
    }

    public void addProduct(Product product, int rackId) {
        products.put(product.getId(), product);
        rackToProductIdMap.put(rackId, product.getId());
    }

    public void removeProduct(int productId, int rackId) {
        products.remove(productId);
        rackToProductIdMap.remove(rackId);
    }

    public boolean isProductAvailable(int rackId) {
        return rackToProductIdMap.containsKey(rackId);
    }

    public double getProductPrice(int rackId) {
        int productId = rackToProductIdMap.getOrDefault(rackId, -1);
        if (productId != -1) {
            Product product = products.get(productId);
            return product.getPrice();
        }
        return -1; // If product not found, return -1 indicating invalid price
    }

    public Product getProduct(int rackId) {
        int productId = rackToProductIdMap.getOrDefault(rackId, -1);
        if (productId != -1) {
            return products.get(productId);
        }
        return null; // If product not found, return null
    }

    public int getNoOfProducts() {
        return products.size();
    }
}

@Getter
@Setter
class VendingMachine {
    private State currentState;
    private double amount;
    private int noOfRacks;
    private List<Rack> racks;
    private int availableRacks;
    private NoMoneyInsertedState noMoneyInsertedState;
    private MoneyInsertedState moneyInsertedState;
    private DispenseState dispenseState;
    private Inventory inventory;

    // The VendingMachine is a Singleton class that ensures it will have only one
    // active instance at a time
    private static VendingMachine vendingMachine = null;

    // Created a private constructor to add a restriction (due to Singleton)
    private VendingMachine() {
        noMoneyInsertedState = new NoMoneyInsertedState();
        moneyInsertedState = new MoneyInsertedState();
        dispenseState = new DispenseState();
        currentState = noMoneyInsertedState;
        inventory = new Inventory();
    }

    // Created a static method to access the singleton instance of VendingMachine
    public static VendingMachine getInstance() {
        if (vendingMachine == null) {
            vendingMachine = new VendingMachine();
        }
        return vendingMachine;
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(vendingMachine, amount);
    }

    public void pressButton(int rackNumber) {
        currentState.pressButton(vendingMachine, rackNumber);
    }

    public void returnChange(double amount) {
        currentState.returnChange(amount);
    }

    public void updateInventory(int rackNumber) {
    }

    public void dispenseProduct(int rackNumber) {
        currentState.dispenseProduct(vendingMachine, rackNumber);
    }

    public int getProductIdAtRack(int rackNumber) {
    }
}

public class VendingSystem {

}
