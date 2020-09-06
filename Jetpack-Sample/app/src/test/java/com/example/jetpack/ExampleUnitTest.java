package com.example.jetpack;

import org.junit.Test;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableList;

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
    public void observableField() {
        UserObservable observableField = new UserObservable();
        observableField.firstName.set("jay");
        int age = observableField.age.get();
        System.out.println(age);
    }

    @Test
    public void observableArrayMap() {
        ObservableArrayMap<String, Object> user = new ObservableArrayMap<>();
        user.put("firstName","Charles");
        user.put("lastName","Darwin");
        user.put("age",17);
        System.out.println(user.get("firstName"));
        System.out.println(user.get("lastName"));
        System.out.println(user.get("age"));
    }

    @Test
    public void observableArrayList() {
        ObservableArrayList<Object> user = new ObservableArrayList<>();
        user.add("Charles");
        user.add("Darwin");
        user.add(17);
        System.out.println(user.get(0));
        System.out.println(user.get(1));
        System.out.println(user.get(2));
    }


}