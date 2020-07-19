package com.example.rxjava;

import org.junit.Test;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;

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
    public void imperative_programming() {
        ArrayList<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);


        for (Integer item : items) {
            if (item % 2 == 0) {
                System.out.println(item);
            }
        }
        items.add(5);
        items.add(6);
        items.add(7);
        items.add(8);
    }

    @Test
    public void reactive_programming() {
        PublishSubject<Integer> items = PublishSubject.create();
        items.onNext(1);
        items.onNext(2);
        items.onNext(3);
        items.onNext(4);
        items.filter(item -> item % 2 == 0).subscribe(System.out::println);
        items.onNext(5);
        items.onNext(6);
        items.onNext(7);
        items.onNext(8);
    }


}