package com.example.myapplication.Inheritance;

import dagger.Component;
import dagger.Module;

@Component(modules = ModuleB.class, dependencies = ComponentA.class)
public interface ComponentB {
    void inject(Foo foo);
}
