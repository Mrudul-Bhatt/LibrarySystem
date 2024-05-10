package com.example.LibrarySystem.StackOverflowSystem.Observer_Observable_DP;

import java.util.ArrayList;
import java.util.List;

import com.example.LibrarySystem.StackOverflowSystem.Notification.Notification;

public class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Notification notification) {
        for (Observer observer : observers) {
            observer.update(notification);
        }
    }
}
