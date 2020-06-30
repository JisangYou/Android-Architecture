package com.example.myapplication.Factory;

import com.example.myapplication.Component.MyClass;
import com.example.myapplication.Component.MyComponent;
import com.example.myapplication.Component.MyModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponentBuilder {
    MyClass myClass();

    @Component.Factory
    interface Factory{
        MyComponent newMyComponent(
                MyModule mm,
                @BindsInstance MyClass myClass
        );
    }
}
