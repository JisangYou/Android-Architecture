package com.example.myapplication;


import com.example.myapplication.Inheritance.ComponentA;
import com.example.myapplication.Inheritance.ComponentB;
import com.example.myapplication.Inheritance.DaggerComponentA;
import com.example.myapplication.Inheritance.DaggerComponentB;
import com.example.myapplication.Inheritance.Foo;
import com.example.myapplication.SubComponent.Cafe;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testCafe() {
        Cafe cafe = new Cafe();
        System.out.println(cafe.orderCoffee());
        System.out.println(cafe.orderCoffee());
        System.out.println(cafe.orderCoffee());
    }

    @Test
    public void testDependency() {
        Foo foo = new Foo();
        ComponentA componentA = DaggerComponentA.create();
        ComponentB componentB = DaggerComponentB.builder().componentA(componentA).build();
        componentB.inject(foo);
        System.out.println(foo.str);
        System.out.println(foo.integer);
    }
}