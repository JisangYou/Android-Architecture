package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Module에서 subcomponents를 정의하는데, 조금 가독성 측면에서(?) 애매한것 같다.
 */

@Module(subcomponents = MainActivityComponent.class)
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
