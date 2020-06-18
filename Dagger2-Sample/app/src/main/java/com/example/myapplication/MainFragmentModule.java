package com.example.myapplication;
import java.util.Random;

import dagger.Module;
import dagger.Provides;

@Module
public class MainFragmentModule {


    @Provides
//    @FragmentScope
    Integer provideInt() {
        return new Random().nextInt();
    }
}

