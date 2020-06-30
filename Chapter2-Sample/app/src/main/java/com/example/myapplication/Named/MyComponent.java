package com.example.myapplication.Named;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {
    void inject(MyClass myclass);
}
