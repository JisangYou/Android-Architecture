package com.example.myapplication.Module;

import androidx.annotation.Nullable;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {
    @Provides
    String provideName() {
        return "Charles";
    }

    @Provides
    int provideAge() {
        return 100;
    }

    @Provides
    @Nullable
    Integer provideInteger() {
        return null;
    }

    @Provides
    Person providePerson(String name, int age) {
        return new Person(name, age);
    }
}
