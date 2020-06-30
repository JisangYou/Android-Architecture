package com.example.myapplication.MapMultiBinding;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public class MapModule2 {
    @IntoMap
    @AnimalKey(Animal.CAT)
    @Provides
    String provideCat() {
        return "Meow";
    }

    @IntoMap
    @AnimalKey(Animal.DOG)
    @Provides
    String provideDog() {
        return "Bow-wow";
    }

    @IntoMap
    @NumberKey(Float.class)
    @Provides
    String provideFloatValue() {
        return "100f";
    }

    @IntoMap
    @NumberKey(Integer.class)
    @Provides
    String provideIntegerValue() {
        return "1";
    }


}
