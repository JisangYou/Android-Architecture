package com.example.myapplication.Singleton;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MyModule.class)
public interface MyComponent {
    Object getObject();
}
