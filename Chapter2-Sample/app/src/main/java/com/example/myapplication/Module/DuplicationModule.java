package com.example.myapplication.Module;

import dagger.Module;
import dagger.Provides;

@Module
class DuplicationModule {
    @Provides
    String provideHelloWorld() {
        return "Hello World";
    }

    @Provides
    String provideCharles() {
        return "Charles";
    }
}
