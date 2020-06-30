package com.example.myapplication.Injection;

import javax.inject.Inject;

public class PersonB {
    @Inject
    String name;

    private int age;

    @Inject
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;

    }
}
