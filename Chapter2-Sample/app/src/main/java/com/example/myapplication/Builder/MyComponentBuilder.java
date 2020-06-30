package com.example.myapplication.Builder;

import com.example.myapplication.Component.MyClass;
import com.example.myapplication.Component.MyModule;

import dagger.BindsInstance;
import dagger.Component;


@Component(modules = {MyModule.class})
public interface MyComponentBuilder {
    MyClass myClass();
    @Component.Builder
    interface Builder{
        Builder myModule(MyModule me);
        @BindsInstance
        Builder myClass(MyClass myClass);
        MyComponentBuilder build();
    }
}
