package com.example.myapplication.lazy_Provider;

import dagger.Component;

@Component(modules = CounterModule.class)
public interface CounterComponent {
    void inject(Counter counter);
}
