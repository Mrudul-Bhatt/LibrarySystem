package com.example.LibrarySystem.AirlineManagementSystem.System2.DesignPatterns.Observer;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String message);
}
