package com.example.features.defaults;

public interface Interface1 {
    default void helloWorld() {
        System.out.println("hi i'm from Interface1");
    }
}
