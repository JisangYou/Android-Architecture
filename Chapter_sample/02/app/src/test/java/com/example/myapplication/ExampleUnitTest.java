package com.example.myapplication;



import com.example.myapplication.Named.DaggerMyComponent;
import com.example.myapplication.Named.MyClass;

import org.junit.Test;



import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Test
    public void myComponent(){
        MyClass myClass = new MyClass();
        DaggerMyComponent.create().inject(myClass);
        System.out.println(myClass.getStrHello());
        System.out.println(myClass.getStrWorld());
    }

}