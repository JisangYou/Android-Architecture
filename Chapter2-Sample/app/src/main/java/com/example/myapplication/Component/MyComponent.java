package com.example.myapplication.Component;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {
    void inject(MyClass myClass);
}
