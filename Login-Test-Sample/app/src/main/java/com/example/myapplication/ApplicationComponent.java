package com.example.myapplication;

import dagger.Component;

@Component
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
