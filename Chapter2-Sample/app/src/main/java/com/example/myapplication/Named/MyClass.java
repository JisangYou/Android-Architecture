package com.example.myapplication.Named;

import javax.inject.Inject;
import javax.inject.Named;

public class MyClass {
    @Inject
    @Named("hello")
    String strHello;

    @Inject
    @Named("world")
    String strWorld;

    public String getStrHello() {
        return strHello;
    }

    public String getStrWorld() {
        return strWorld;
    }

}
