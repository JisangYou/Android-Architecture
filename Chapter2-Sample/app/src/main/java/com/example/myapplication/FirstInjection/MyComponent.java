package com.example.myapplication.FirstInjection;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {
    String getString();
}

