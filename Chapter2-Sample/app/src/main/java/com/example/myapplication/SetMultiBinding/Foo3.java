package com.example.myapplication.SetMultiBinding;

import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

public class Foo3 {
    @Inject
    Set<String> strings;

    public void print() {
        for (Iterator itr = strings.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next());
        }
    }
}
