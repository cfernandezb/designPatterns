package com.augusto.designpatterns.Factory;

public class FactoryBasic {

    public static Payment createPayment(String paymentType) {
        if (paymentType == null || paymentType.isEmpty()) {
            throw new IllegalArgumentException("Payment type cannot be null or empty");
        }

        if (paymentType.equals("paypal")) {
            return new PaypalPayment();
        } else if (paymentType.equals("creditcard")) {
            return new CreditCardPayment();
        } else if (paymentType.equals("crypto")) {
            return new CryptoPayment();
        } else {
            throw new IllegalArgumentException("Unknown payment type: " + paymentType);
        }
    }
}
