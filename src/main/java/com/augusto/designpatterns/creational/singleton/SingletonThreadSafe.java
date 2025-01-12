package com.augusto.designpatterns.creational.singleton;

public class SingletonThreadSafe {
        private static volatile SingletonThreadSafe INSTANCE;

        private SingletonThreadSafe() {}

        public static SingletonThreadSafe getInstance() {
            if (INSTANCE == null) {
                synchronized (SingletonThreadSafe.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new SingletonThreadSafe();
                    }
                }
            }
            return INSTANCE;
        }
    }
