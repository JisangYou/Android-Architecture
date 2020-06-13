package com.example.myapplication._02;


import dagger.Module;
import dagger.Provides;

@Module
public class ModuleA {
    @Provides
    A provideA() {
        return new A();
    }
    class A {

    }

}



