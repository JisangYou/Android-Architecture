package com.example.myapplication.SubComponent;

import dagger.Module;
import dagger.Provides;

@Module
public class MachineModule {
    @Provides
    CoffeeBean provideCoffeeBean(){
        return new CoffeeBean();
    }
}
