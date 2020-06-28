package com.example.myapplication.Binds;

import dagger.Component;

@Component(modules = CommonModule.class)
public interface NoStrComponent {
    void inject(Foo foo);
}
