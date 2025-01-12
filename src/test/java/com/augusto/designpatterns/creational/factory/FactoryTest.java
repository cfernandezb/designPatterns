package com.augusto.designpatterns.creational.factory;

import com.augusto.designpatterns.creational.Factory.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {

    @Test
    void TestCreatePaymentValidTypes(){
        Payment payment = FactoryBasic.createPayment("paypal");
        assertNotNull(payment);
        assertInstanceOf(PaypalPayment.class, payment);

        payment = FactoryBasic.createPayment("creditcard");
        assertNotNull(payment);
        assertInstanceOf(CreditCardPayment.class, payment);

        payment = FactoryBasic.createPayment("crypto");
        assertNotNull(payment);
        assertInstanceOf(CryptoPayment.class, payment);
    }

    @Test
    void testCreatePayment_InvalidType() {
        // Verificar que un tipo no soportado lanza una excepción
        assertThrows(IllegalArgumentException.class, () -> {
            FactoryBasic.createPayment(null);
        });
    }

    @Test
    void testCreatePayment_ElegantFactory() {
        Payment payment = ElegantFactory.createPayment(PaymentType.CREDITCARD);
        assertNotNull(payment);
        assertInstanceOf(CreditCardPayment.class, payment);

        payment = ElegantFactory.createPayment(PaymentType.PAYPAL);
        assertNotNull(payment);
        assertInstanceOf(PaypalPayment.class, payment);

        payment = ElegantFactory.createPayment(PaymentType.CRYPTO);
        assertNotNull(payment);
        assertInstanceOf(CryptoPayment.class, payment);
    }

    @Test
    void testCreatePayment_ElegantFactory_InvalidType() {
        // Verificar que un tipo no soportado lanza una excepción
        assertThrows(IllegalArgumentException.class, () -> {
            ElegantFactory.createPayment(null);
        });
    }
}
