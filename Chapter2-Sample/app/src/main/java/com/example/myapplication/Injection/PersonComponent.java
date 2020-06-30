package com.example.myapplication.Injection;

import dagger.Component;

@Component(modules = PersonModule.class)
public interface PersonComponent {

    PersonA getPersonA();

    void inject(PersonB personB);
}
