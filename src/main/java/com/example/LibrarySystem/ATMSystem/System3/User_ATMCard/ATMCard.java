package com.example.LibrarySystem.ATMSystem.System3.User_ATMCard;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ATMCard {
    private String cardNumber;
    private String customerName;
    private Date cardExpiryDate;
    private int pin;

    public ATMCard(String cardNumber, String customerName, Date cardExpiryDate, int pin) {
        this.cardNumber = cardNumber;
        this.customerName = customerName;
        this.cardExpiryDate = cardExpiryDate;
        this.pin = pin;
    }

    public boolean verifyPIN(int enteredPIN) {
        return this.pin == enteredPIN;
    }
}
