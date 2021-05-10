package com.example.features.defaults;

public interface Interface2 {
    default void helloWorld() {
        System.out.println("hi i'm from Interface2");
    }
}
