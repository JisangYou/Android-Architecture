package com.example.myapplication.Qualifier;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {
    void inject(MyClass myClass);
}
