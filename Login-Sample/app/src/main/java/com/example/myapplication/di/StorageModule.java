package com.example.myapplication.di;

import com.example.myapplication.storage.SharedPreferenceStorage;
import com.example.myapplication.storage.Storage;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class StorageModule {

    abstract Storage provideSharedPreferences(SharedPreferenceStorage sharedPreferenceStorage);
}
