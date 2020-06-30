package com.example.myapplication.Module;

import androidx.annotation.Nullable;

import dagger.Component;

@Component(modules = MyModule.class)
//public class MyComponent {
public interface MyComponent {
    @Nullable
    Integer getInteger();
}
