package com.example.LibrarySystem.AirlineManagementSystem.System2.Payment;

import com.example.LibrarySystem.AirlineManagementSystem.System2.Enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard extends Payment {
    private String nameOnCard;
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCard(int paymentId, double amount, String nameOnCard, String cardNumber, String expiryDate,
                      String cvv) {
        super(paymentId, amount);
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    // Implementation of the abstract method to process credit card payment
    @Override
    public boolean makePayment() {
        // Simulate payment processing logic for credit card
        System.out.println("Processing credit card payment of amount: " + super.getAmount());
        System.out.println("Card Details: " + nameOnCard + ", " + cardNumber + ", Expiry: " + expiryDate);
        // Simulate some validation and processing logic
        if (validateCardDetails()) {
            // Assume payment is successful after validation
            setPaymentStatus(PaymentStatus.COMPLETED);
            return true;
        } else {
            setPaymentStatus(PaymentStatus.FAILED);
            return false;
        }
    }

    // Validate credit card details (simple validation for demonstration purposes)
    private boolean validateCardDetails() {
        // In real-world scenarios, we would have complex validation and API calls to the payment gateway
        return cardNumber != null && cardNumber.length() == 16 && !cvv.isEmpty() && !expiryDate.isEmpty();
    }
}
