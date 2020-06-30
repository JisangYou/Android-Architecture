package com.example.myapplication.Inheritance;

import dagger.Component;
import dagger.Module;

@Component(modules = ModuleA.class)
public interface ComponentA {
    String provideString();
}
