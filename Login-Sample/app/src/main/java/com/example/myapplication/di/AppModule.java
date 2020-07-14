package com.example.myapplication.di;


import com.example.myapplication.ui.login.LoginActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;


@Module(subcomponents = {LoginComponent.class})
public class AppModule {

    //    @ActivityScope -? scope referrence error
    @Provides
    @Named("login")
    String login() {
        return LoginActivity.class.getSimpleName();
    }
}
