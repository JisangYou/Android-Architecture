package com.example.myapplication.di;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class StorageModule {

    abstract String provideSharedPreferences(String string);
}
