package com.example.myapplication.MapMultiBinding;

import java.util.Map;

import dagger.Component;

@Component(modules = MapModule2.class)
public interface MapKeyComponent {
    Map<Animal, String> getStringByAnimal();

    Map<Class<? extends Number>, String> getStringByNumber();
}
