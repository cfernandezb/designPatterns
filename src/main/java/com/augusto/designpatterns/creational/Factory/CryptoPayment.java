package com.augusto.designpatterns.creational.Factory;

public class CryptoPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing crypto payment of $" + amount);
    }
}
