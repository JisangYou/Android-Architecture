package com.example.myapplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, SubcomponentsModule.class})
public interface ApplicationComponent {
    //    void inject(MainActivity mainActivity);
    LoginComponent.Factory loginComponent();
}
