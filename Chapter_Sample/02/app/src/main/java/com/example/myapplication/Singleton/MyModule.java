package com.example.myapplication.Singleton;

import com.example.myapplication.Scope.UserScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {
    @Provides
//    @Singleton
    @UserScope
    Object provideObject() {
        return new Object();
    }
}
