package com.example.myapplication;





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
    public void testProvider(){
        CounterComponent component = DaggerCounterComponent.create();
        Counter counter = new Counter();
        component.inject(counter);
        counter.printProvider();
    }
}