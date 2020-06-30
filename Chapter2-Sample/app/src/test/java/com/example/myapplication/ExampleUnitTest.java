package com.example.myapplication;


import com.example.myapplication.Binds.BindsComponent;

import com.example.myapplication.Binds.DaggerBindsComponent;
import com.example.myapplication.Binds.DaggerNoStrComponent;
import com.example.myapplication.Binds.DaggerStrComponent;
import com.example.myapplication.Binds.Foo;
import com.example.myapplication.Binds.Foo2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void testFoo() {
        Foo foo = new Foo();
        DaggerStrComponent.create().inject(foo);
        System.out.println(foo.str.isPresent());
        System.out.println(foo.str.get());
        DaggerNoStrComponent.create().inject(foo);
        System.out.println(foo.str.isPresent());
        System.out.println(foo.str.get());
    }

    @Test
    public void testBindInstance() {
        String hello = "Hello World";
        Foo2 foo = new Foo2();
        BindsComponent component = DaggerBindsComponent.builder().setString(hello).build();
        component.inject(foo);
        assertEquals("Hello World", foo.str);
    }

}