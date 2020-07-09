package com.example.myapplication.module;

import com.example.myapplication.ui.login.LoginActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {
    @Provides
//    @ActivityScope
    String provideActivityName() {
        return LoginActivity.class.getSimpleName();
    }
}
