package com.example.myapplication.SubComponent;

import javax.inject.Inject;

public class Cafe {
    @Inject
    Machine coffeeMachine;

    public Cafe() {
        DaggerCafeComponent.create().inject(this);
    }

    public Coffee orderCoffee() {
        return coffeeMachine.extract();
    }
}
