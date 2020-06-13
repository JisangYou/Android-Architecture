package com.example.myapplication._02;

import dagger.Component;

@Component(modules = PersonModule.class)
public interface PersonComponent {

    PersonA getPersonA();

    void inject(PersonB personB);
}
