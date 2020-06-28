package com.example.myapplication;


import com.example.myapplication.Singleton.DaggerMyComponent;
import com.example.myapplication.Singleton.MyComponent;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testObjectIdentity() {
        MyComponent myComponent = DaggerMyComponent.create();
        Object temp1 = myComponent.getObject();
        Object temp2 = myComponent.getObject();
        assertNotNull(temp1);
        assertNotNull(temp2);
        assertSame(temp1, temp2);
    }

}