package com.augusto.designpatterns.creational.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BuilderTest {

    @Test
    void testHttpRequestBuilder() {
        HttpRequest request = new HttpRequest.Builder()
                .setMethod("GET")
                .setUrl("https://example.com")
                .setBody("Hello, world!")
                .setHeaders("Content-Type: text/plain")
                .setTimeout(5)
                .build();

        assertEquals("GET", request.getMethod());
        assertEquals("https://example.com", request.getUrl());
        assertEquals("Hello, world!", request.getBody());
        assertEquals("Content-Type: text/plain", request.getHeaders());
        assertEquals(5, request.getTimeout());
    }

    @Test
    void testHttpResquestBuilderWithDefaults() {
        HttpRequest request = new HttpRequest.Builder().build();

        assertEquals("GET", request.getMethod());
        assertNull(request.getUrl());
        assertNull(request.getBody());
        assertNull(request.getHeaders());
        assertEquals(5, request.getTimeout());
    }
}

