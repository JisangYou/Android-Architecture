package com.example.myapplication.Qualifier;

import javax.inject.Inject;

public class MyClass {
    @Inject
    @Hello
    String strHello;

    @Inject
    String strWorld;
}
