package com.example.myapplication.module;


import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = LoginActivityComponent.class)
public class AppModule {
    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(App app) {
        return app.getSharedPreferences(
                "default",
                Context.MODE_PRIVATE
        );
    }
}
