package com.example.myapplication.AbstractMultiBinding;

import java.util.Set;

import dagger.Component;

@Component(modules = MultibindsModules.class)
public interface MultibindsComponent {
    Set<String> getString();
}

