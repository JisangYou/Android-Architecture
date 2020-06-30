package com.example.myapplication;


import com.example.myapplication.Component.DaggerMyComponent;
import com.example.myapplication.Component.MyClass;
import com.example.myapplication.Component.MyComponent;
import com.example.myapplication.Injection.DaggerPersonComponent;
import com.example.myapplication.Injection.PersonA;
import com.example.myapplication.Injection.PersonB;
import com.example.myapplication.Injection.PersonComponent;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testMemberInjection() {
        MyClass myClass = new MyClass();
        String str = myClass.getStr();
        assertNull("조회 결과 null", str);
        MyComponent myComponent = DaggerMyComponent.create();
        myComponent.inject(myClass);
        str = myClass.getStr();
        assertEquals("Hello world", str);
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
}