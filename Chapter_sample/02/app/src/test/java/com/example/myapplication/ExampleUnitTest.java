package com.example.myapplication;


import com.example.myapplication._01.DaggerMyComponent;
import com.example.myapplication._01.MyComponent;
import com.example.myapplication._02.DaggerMyComponent2;
import com.example.myapplication._02.DaggerPersonComponent;
import com.example.myapplication._02.MyClass;
import com.example.myapplication._02.MyComponent2;
import com.example.myapplication._02.PersonA;
import com.example.myapplication._02.PersonB;
import com.example.myapplication._02.PersonComponent;
import com.example.myapplication.lazy_Provider.Counter;
import com.example.myapplication.lazy_Provider.CounterComponent;
import com.example.myapplication.lazy_Provider.DaggerCounterComponent;

import org.junit.Test;

import dagger.android.support.DaggerFragment;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testHelloWorld() {
        MyComponent myComponent = DaggerMyComponent.create();
        System.out.println("result = " + myComponent.getString());
    }

    @Test
    public void testMemberInjection() {
        MyClass myClass = new MyClass();
        String str = myClass.getStr();
        assertNull("조회결과 null", str);
        MyComponent2 myComponent2 = DaggerMyComponent2.create();
        myComponent2.inject(myClass);
        str = myClass.getStr();
        assertEquals("Hello World", str);
    }

    @Test
    public void testInjection() {
        PersonComponent personComponent = DaggerPersonComponent.create();

        PersonA personA = personComponent.getPersonA();
        System.out.println(personA.getName() + ":" + personA.getAge());

        PersonB personB = new PersonB();
        DaggerPersonComponent.create().inject(personB);
        assertEquals("Charles", personB.getName());

        assertEquals(100, personB.getAge());
    }

    @Test
    public void testLazy(){
        CounterComponent component = DaggerCounterComponent.create();
        Counter counter = new Counter();
        component.inject(counter);
        counter.printLazy();
    }
}