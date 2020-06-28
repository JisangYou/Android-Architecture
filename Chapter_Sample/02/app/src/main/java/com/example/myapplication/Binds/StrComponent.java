package com.example.myapplication.Binds;


import dagger.Component;

@Component(modules = {CommonModule.class, HelloModule.class})
public interface StrComponent {
    void inject(Foo foo);
}
