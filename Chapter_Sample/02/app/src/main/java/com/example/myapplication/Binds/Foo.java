package com.example.myapplication.Binds;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;

public class Foo {
    @Inject
    public Optional<String> str;

    @Inject
    public Optional<Provider<String>> str2;

    @Inject
    public Optional<Lazy<String>> str3;


}
