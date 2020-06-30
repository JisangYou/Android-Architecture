package com.example.myapplication.MapMultiBinding;

import java.util.Map;

import dagger.Component;

@Component(modules = MapModule.class)
public interface MapComponent {
    Map<String, Long> getLongByString();

    Map<Class<?>, String> getStringByClass();
}
