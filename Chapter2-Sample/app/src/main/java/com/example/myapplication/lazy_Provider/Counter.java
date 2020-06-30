package com.example.myapplication.lazy_Provider;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;

public class Counter {

    @Inject
    Provider<Integer> provider;

    public void printProvider() {
        System.out.println("printing...");
        System.out.println(provider.get());
        System.out.println(provider.get());
        System.out.println(provider.get());
    }
}
