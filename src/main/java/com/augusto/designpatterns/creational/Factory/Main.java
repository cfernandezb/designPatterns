package com.augusto.designpatterns.creational.Factory;

public class Main {
    public static void main(String[] args) {
        Payment payment = FactoryBasic.createPayment("paypal");
        payment.processPayment(100);

        payment = FactoryBasic.createPayment("creditcard");
        payment.processPayment(100);

        payment = FactoryBasic.createPayment("crypto");
        payment.processPayment(100);

        payment = ElegantFactory.createPayment(PaymentType.CREDITCARD);
        payment.processPayment(100);

        payment = ElegantFactory.createPayment(PaymentType.PAYPAL);
        payment.processPayment(100);

        payment = ElegantFactory.createPayment(PaymentType.CRYPTO);
        payment.processPayment(100);
    }
}
