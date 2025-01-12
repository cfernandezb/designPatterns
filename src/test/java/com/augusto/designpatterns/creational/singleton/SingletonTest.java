package com.augusto.designpatterns.creational.singleton;

import com.augusto.designpatterns.creational.singleton.Singleton;
import com.augusto.designpatterns.creational.singleton.SingletonEager;
import com.augusto.designpatterns.creational.singleton.SingletonThreadSafe;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {

    private static final int NUM_OF_THREADS = 50;

    @Test
    void testSingletonInstance(){
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void testSingletonEagerInstance(){
        SingletonEager instance1 = SingletonEager.getInstance();
        SingletonEager instance2 = SingletonEager.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void testSingletonThreadSafeInstance(){
        SingletonThreadSafe instance1 = SingletonThreadSafe.getInstance();
        SingletonThreadSafe instance2 = SingletonThreadSafe.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void testSingletonThreadSafeMultithreaded() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_OF_THREADS);
        Set<SingletonThreadSafe> instances = new HashSet<>();

        for (int i = 0; i < NUM_OF_THREADS; i++) {
            executorService.submit(() -> {
                SingletonThreadSafe instance = SingletonThreadSafe.getInstance();
                synchronized (instances) { // Sincronización para evitar condiciones de carrera al añadir a la colección evitando: ConcurrentModificationException
                    instances.add(instance);
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES); // Espera a que terminen todos los hilos

        assertEquals(1, instances.size(), "Should only have one instance");
    }

    @Test
    void testSingletonEagerMultithreaded() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_OF_THREADS);
        Set<SingletonEager> instances = new HashSet<>();

        for (int i = 0; i < NUM_OF_THREADS; i++) {
            executorService.submit(() -> {
                SingletonEager instance = SingletonEager.getInstance();
                synchronized (instances) { // Sincronización para evitar condiciones de carrera al añadir a la colección
                    instances.add(instance);
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES); // Espera a que terminen todos los hilos

        assertEquals(1, instances.size(), "Should only have one instance");
    }


}
