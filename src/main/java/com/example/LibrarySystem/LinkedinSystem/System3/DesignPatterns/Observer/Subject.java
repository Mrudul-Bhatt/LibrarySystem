package com.example.LibrarySystem.LinkedinSystem.System3.DesignPatterns.Observer;

public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers(String message);
}
