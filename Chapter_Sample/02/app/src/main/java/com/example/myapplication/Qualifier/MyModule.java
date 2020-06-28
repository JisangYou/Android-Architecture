package com.example.myapplication.Qualifier;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {
    @Provides
    @Hello
    String provideHello() {
        return "Hello";
    }

    @Provides
    String provideWorld(){
        return "World";
    }
}
