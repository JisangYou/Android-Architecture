package com.example.myapplication.MapMultiBinding;

import dagger.MapKey;

@MapKey
public @interface NumberKey {
    Class<? extends Number> value();
}
