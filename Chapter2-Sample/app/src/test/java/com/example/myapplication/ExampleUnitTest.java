package com.example.myapplication;


import com.example.myapplication.Qualifier.DaggerMyComponent;
import com.example.myapplication.Qualifier.MyClass;

import org.junit.Test;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void myComponent() {
        MyClass myClass = new MyClass();
        DaggerMyComponent.create().inject(myClass);
        System.out.println(myClass.getStrHello());
        System.out.println(myClass.getStrWorld());
    }

}