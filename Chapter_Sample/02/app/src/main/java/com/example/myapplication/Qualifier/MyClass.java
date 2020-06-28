package com.example.myapplication.Qualifier;

import javax.inject.Inject;

public class MyClass {
    @Inject
    @Hello
    String strHello;

    @Inject
    String strWorld;

    public String getStrHello() {
        return strHello;
    }

    public void setStrHello(String strHello) {
        this.strHello = strHello;
    }

    public String getStrWorld() {
        return strWorld;
    }

    public void setStrWorld(String strWorld) {
        this.strWorld = strWorld;
    }
}
