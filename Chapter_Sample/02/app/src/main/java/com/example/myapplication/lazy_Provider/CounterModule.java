package com.example.myapplication.lazy_Provider;

import dagger.Module;
import dagger.Provides;

@Module
public class CounterModule {
    int next = 100;

    @Provides
    Integer provideInteger() {
        System.out.println("computing...");
        return next++;
    }
}
