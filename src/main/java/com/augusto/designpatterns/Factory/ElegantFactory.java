package com.augusto.designpatterns.Factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ElegantFactory {
    private static final Map<PaymentType, Supplier<Payment>> payments = new HashMap<>();

    static {
        payments.put(PaymentType.CREDITCARD, CreditCardPayment::new);
        payments.put(PaymentType.PAYPAL, PaypalPayment::new);
        payments.put(PaymentType.CRYPTO, CryptoPayment::new);
    }

    public static Payment createPayment(PaymentType paymentType) {
        Supplier<Payment> paymentSupplier = payments.get(paymentType);
        if (paymentSupplier == null) {
            throw new IllegalArgumentException("Unknown payment type: " + paymentType);
        }
        return paymentSupplier.get();
    }
}
