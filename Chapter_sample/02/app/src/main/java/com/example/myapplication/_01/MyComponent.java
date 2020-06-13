package com.example.myapplication._01;


import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent{
    String getString();

}
