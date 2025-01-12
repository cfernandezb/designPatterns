package com.augusto.designpatterns.creational.prototype;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrototypeTest {

    @Test
    void testCloneCreatesIndependentCopy() throws CloneNotSupportedException {
        List<String> newDetails = List.of("Product A - $100", "Product B - $200", "Product C - $300");
        PrototypeDocument original = new PrototypeDocument("Factura", "Factura A", "Cliente A", newDetails);

        PrototypeDocument copy = original.clone();
        PrototypeDocument copy2 = original.clone();

        PrototypeDocument copy3 = original.clone();
        copy3.setTitle("Factura B");
        copy3.setClient("Cliente B");
        copy3.getDetails().add("Product D - $400");

        assertEquals(original, copy);
        assertEquals(original, copy2);
        assertEquals("Cliente A", copy.getClient());
        assertEquals("Factura A", copy2.getTitle());
        assertEquals("Factura B", copy3.getTitle());
        assertEquals("Cliente B", copy3.getClient());
        assertEquals(4, copy3.getDetails().size());
    }
}
