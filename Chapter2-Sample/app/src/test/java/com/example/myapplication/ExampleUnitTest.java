package com.example.myapplication;


import com.example.myapplication.Binds.BindsComponent;

import com.example.myapplication.Binds.DaggerBindsComponent;
import com.example.myapplication.Binds.DaggerNoStrComponent;
import com.example.myapplication.Binds.DaggerStrComponent;
import com.example.myapplication.Binds.Foo;
import com.example.myapplication.Binds.Foo2;
import com.example.myapplication.MapMultiBinding.Animal;
import com.example.myapplication.MapMultiBinding.DaggerMapComponent;
import com.example.myapplication.MapMultiBinding.DaggerMapKeyComponent;
import com.example.myapplication.MapMultiBinding.Foo4;
import com.example.myapplication.MapMultiBinding.MapComponent;
import com.example.myapplication.MapMultiBinding.MapKeyComponent;
import com.example.myapplication.MapMultiBinding.ParentChild.ChildComponent;
import com.example.myapplication.MapMultiBinding.ParentChild.DaggerParentComponent;
import com.example.myapplication.MapMultiBinding.ParentChild.ParentComponent;
import com.example.myapplication.SetMultiBinding.DaggerSetComponent;
import com.example.myapplication.SetMultiBinding.Foo3;

import org.junit.Test;

import java.util.Iterator;

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

    @Test
    public void testMultibindingSet() {
        Foo3 foo3 = new Foo3();
        DaggerSetComponent.create().inject(foo3);
        foo3.print();
    }

    @Test
    public void testMultibindingMapTest() {
        MapComponent component = DaggerMapComponent.create();
        long value = component.getLongByString().get("foo");
        String str = component.getStringByClass().get(Foo4.class);

        System.out.println(value);
        System.out.println(str);
    }

    @Test
    public void testCustomMapKey() {
        MapKeyComponent component = DaggerMapKeyComponent.create();
        String cat = component.getStringByAnimal().get(Animal.CAT);
        String dog = component.getStringByAnimal().get(Animal.DOG);
        String number = component.getStringByNumber().get(Float.class);
        System.out.println(cat);
        System.out.println(dog);
        System.out.println(number);
    }

    @Test
    public void testMultibindingWithSubcomponent() {
        ParentComponent parentComponent = DaggerParentComponent.create();
        ChildComponent childComponent = parentComponent.childCompBuilder().build();

        System.out.println("List set in Parent");

        Iterator itr = parentComponent.strings().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("List set in child");

        itr = childComponent.strings().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}