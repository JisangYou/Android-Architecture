package com.example.myapplication;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = MainFragmentComponent.class)
public class MainActivityModule {
    @Provides
//    @ActivityScope
    String provideActivityName() {
        return MainActivity.class.getSimpleName();
    }
}
