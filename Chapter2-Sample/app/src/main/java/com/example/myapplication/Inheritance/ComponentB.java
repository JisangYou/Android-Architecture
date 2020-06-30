package com.example.myapplication.Inheritance;

import dagger.Component;

@Component(modules = ModuleB.class, dependencies = ComponentA.class)
public interface ComponentB {
    void inject(Foo foo);
}
