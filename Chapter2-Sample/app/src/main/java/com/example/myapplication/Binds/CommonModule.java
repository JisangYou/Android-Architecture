package com.example.myapplication.Binds;

import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;

@Module
public abstract class CommonModule {
    @BindsOptionalOf
    abstract String bindsOptionalOfString();
}
