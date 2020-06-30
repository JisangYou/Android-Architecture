package com.example.myapplication.Component;

import javax.inject.Inject;

import dagger.Component;

public class MyClass {
    @Inject
    String str;

    public String getStr() {
        return str;
    }
}
