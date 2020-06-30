package com.example.myapplication.Named;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {
    @Provides
    @Named("hello")
    String provideHello(){
        return "Hello";
    }

    @Provides
    @Named("world")
    String provideWorld(){
        return "World";
    }
}
