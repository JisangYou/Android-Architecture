package com.example.myapplication;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

//@ActivityScope
@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivitySubComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {

    }
}
