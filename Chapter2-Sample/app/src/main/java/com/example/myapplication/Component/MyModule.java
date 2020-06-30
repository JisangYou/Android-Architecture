package com.example.myapplication.Component;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {
    @Provides
    String provideName() {
        return "Hello World";
    }
}
