package com.example.myapplication.component;

import com.example.myapplication.module.NetworkModule;
import com.example.myapplication.module.SubcomponentsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, SubcomponentsModule.class})
public interface ApplicationComponent {
    //    void inject(MainActivity mainActivity);
    LoginComponent.Factory loginComponent();
}
