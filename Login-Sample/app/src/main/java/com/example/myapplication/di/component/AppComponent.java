package com.example.myapplication.di.component;

import com.example.myapplication.di.module.AppModule;
import com.example.myapplication.di.module.RegisterModule;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    LoginComponent.Factory loginComponent();

    /**
     * 여기 밑으로, registerComponent 추가 및 다른 로직 추가
     */
    RegisterComponent.Factory registerComponent();
}

