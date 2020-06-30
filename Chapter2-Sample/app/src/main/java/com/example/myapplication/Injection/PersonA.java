package com.example.myapplication.Injection;

import javax.inject.Inject;

public class PersonA {
    private String name;
    private int age;

    @Inject
    public PersonA(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
