package com.example.myapplication.MapMultiBinding;

import dagger.MapKey;

@MapKey
public @interface AnimalKey {
    Animal value();
}
