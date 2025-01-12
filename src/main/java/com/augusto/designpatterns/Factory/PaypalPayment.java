package com.augusto.designpatterns.Factory;

public class PaypalPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing paypal payment of $" + amount);
    }
}
