package com.example.myapplication.Binds;

import dagger.Module;
import dagger.Provides;

@Module
public class HelloModule {
    @Provides
    String provideString() {
        return "Hello";
    }
}
