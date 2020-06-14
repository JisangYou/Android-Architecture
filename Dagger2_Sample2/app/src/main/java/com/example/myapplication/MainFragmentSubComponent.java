package com.example.myapplication;


import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = MainFragmentModule.class)
public interface MainFragmentSubComponent extends AndroidInjector<MainFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainFragment>{

    }
}
