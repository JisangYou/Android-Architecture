package com.example.myapplication._02;

import com.example.myapplication._01.MyModule;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent2 {
    void inject(MyClass myClass);
}
