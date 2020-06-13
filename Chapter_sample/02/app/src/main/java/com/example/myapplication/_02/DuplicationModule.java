package com.example.myapplication._02;

import dagger.Module;
import dagger.Provides;

@Module
public class DuplicationModule {
    @Provides
    String provideHelloWorld() {
        return "Hello World";
    }

    @Provides
    String provideCharles() {
        return "Charles";
    }
}
