package com.example.myapplication.di.module;

import com.example.myapplication.di.component.RegisterComponent;
import com.example.myapplication.ui.login.LoginActivity;
import com.example.myapplication.ui.register.RegisterActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = RegisterComponent.class)
public class RegisterModule {
    @Provides
    @Named("register")
    String register() {
        return RegisterActivity.class.getSimpleName();
    }


}
