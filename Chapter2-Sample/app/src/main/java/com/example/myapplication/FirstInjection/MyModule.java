package com.example.myapplication.FirstInjection;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {
    @Provides
    String provideHelloWorld() {
        return "Hello World";
    }
}
